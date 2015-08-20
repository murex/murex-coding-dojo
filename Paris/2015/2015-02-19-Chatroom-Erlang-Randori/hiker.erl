-module(hiker).
-export([chatroom/0,enter/3]).
chatroomLoop(ClientPids) ->
  receive
    {enter, Name, Pid} -> NewClientPids = [Pid|ClientPids],
                          broadcast_message(NewClientPids , Name ++ " entered the room"),
                          chatroomLoop(NewClientPids)
    _ -> chatroomLoop(ClientPids)
  end.
broadcast_message(ClientPids, Message) ->
  lists:foreach(
    fun(ClientPid) -> ClientPid! {message, Message} end,
    ClientPids
  ).
 
chatroom() ->
  spawn(fun() -> chatroomLoop([]) end).
enter(Room, Name) ->
  Room! {enter, Name, self()}.