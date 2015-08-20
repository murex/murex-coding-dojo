-module(hiker_tests).
-include_lib("eunit/include/eunit.hrl").
-import(hiker, [chatroom/0,enter/3]).
a_client_can_enter_a_room_test() ->
  Room = chatroom(),
  enter(Room,"BigJim",self()),
  assert_receive("BigJim entered the room").
   
two_clients_can_enter_a_room_test() ->
  Room = chatroom(),
  enter(Room,"BigJim"),
  assert_receive("BigJim entered the room"),
  enter(Room,"Barbie"),
  assert_receive("Barbie entered the room").
assert_receive(ExpectedMessage) ->
  receive
    {message, ExpectedMessage} -> nop
    after 500 -> ?assertEqual(ExpectedMessage, timeout)
  end.
two_distinct_clients_receive_notifications_test() ->
  Room = chatroom(),
  enter(Room, "BigJim"),
  spawn( fun() -> enter(Room, "Barbie", self()) end),
  assert_receive("Barbie entered the room").
a_client_can_enter_and_leave_a_room_test() ->
  Room = chatroom(),
  enter(Room,"BigJim"),
  assert_receive("BigJim entered the room").