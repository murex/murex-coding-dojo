package chatroom
type Chatroom struct {
    clients []Client
}
func newChatroom() *Chatroom{
    return new(Chatroom)
}
func (room *Chatroom) enter(newClient Client) {
    room.clients = append(room.clients,newClient)
    for _,client := range room.clients {
    client.notify(newClient.name() + " entered the room")
    }  
}
type Client interface {
    notify(message string)
    name() string
}