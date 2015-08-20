package chatroom
import ("testing")
 
/*
// Acceptance test
func Test_our_chatroom_is_live(t *testing.T) {
    var chatroom *Chatroom = new (Chatroom)
    bigJim := ClientMock{"Big Jim", chatroom, noMsg}
    barbie:= ClientMock{"Barbie", chatroom, noMsg}
    bigJim.enter()
    barbie.enter()
    if (bigJim.popLastMessage() != "Barbie entered the room") {
        t.Error("Big Jim should be notified of Barbie's arrival");
    }
     
    bigJim.says("I am stronger than you Barbie");
    if (barbie.popLastMessage() != "Big Jim: I am stronger than you Barbie") {
        t.Error("Barbie should receive Big Jim's messages");
    }
    if (bigJim.popLastMessage() != "Big Jim: I am stronger than you Barbie") {
        t.Error("Big Jim should receive his own messages");
    }
    bigJim.leaves();
    if (barbie.popLastMessage() != "Big Jim left the room") {
        t.Error("Barbie should be notified of Big Jim's departure");
    }
    barbie.says("Better of alone");
    if (bigJim.popLastMessage() != "") {
        t.Error("Big Jim should not receive messages after leaving");
    }   
   
}
  */
/*
// Test plan
enter
messages
own messages
multithreading of messages
exit
no more messages after exit
*/
 
type ClientMock struct {
    _name string
    chatroom *Chatroom
    lastMessage string
}
func (client *ClientMock) notify(message string) {
    client.lastMessage = message
}
func (client *ClientMock) enter(){
    client.chatroom.enter(client)
}
func (client *ClientMock) name() string{
    return client._name
}
var noMsg string = "vide"
func (client *ClientMock) popLastMessage () string {
    var result = client.lastMessage
    client.lastMessage = noMsg;
    return result;
}
func Test_clients_can_enter_the_chatroom(t *testing.T) {
    var chatroom *Chatroom = newChatroom()
    bigJim := ClientMock{"Big Jim", chatroom, noMsg}
    bigJim.enter()
    if (bigJim.popLastMessage() != "Big Jim entered the room") {
        t.Error("FAIL: Big Jim should be notified of his arrival")
    }
}
func Test_our_chatroom_is_live(t *testing.T) {
    var chatroom *Chatroom = newChatroom()
    bigJim := ClientMock{"Big Jim", chatroom, noMsg}
    barbie := ClientMock{"Barbie", chatroom, noMsg}
    bigJim.enter()
    barbie.enter()
    if (bigJim.popLastMessage() != "Barbie entered the room") {
        t.Error("FAIL: Big Jim should be notified of Barbie's arrival");
    }
}