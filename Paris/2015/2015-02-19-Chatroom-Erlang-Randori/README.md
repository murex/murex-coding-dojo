# Acceptance scenario

```
var chatroom *Chatroom = new (Chatroom)
bigJim := ClientMock{"Big Jim", chatroom, noMsg}
barbie:= ClientMock{"Barbie", chatroom, noMsg}
bigJim.enter()
barbie.enter()
assert(bigJim.popLastMessage() == "Barbie entered the room")
  
bigJim.says("I am stronger than you Barbie");
assert(barbie.popLastMessage() == "Big Jim: I am stronger than you Barbie")
assert(bigJim.popLastMessage() == "Big Jim: I am stronger than you Barbie")
bigJim.leaves();
assert(barbie.popLastMessage() == "Big Jim left the room")
barbie.says("Better of alone");
assert(bigJim.popLastMessage() == "")
```

# Retrospective

* on a été plus loin qu'avec go
* syntaxe plus claire
* message d'erreurs beaucoup moins
* syntaxe des methodes pas evidentes à deviner
* threads necessaires mais faciles
* nouvelle équipe qui nous rejoint pour le dojo
* c'était cool

# The Code 

On cyber dojo http://cyber-dojo.org/kata/edit/88814D28B5

