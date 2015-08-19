require('./hiker.js');
describe("Animal Quiz", function() {
  var message;
  var quiz;
  beforeEach(function() {
    message = [];
    quiz = newQuiz(function(msg) { message.push(msg); });
    quiz.startGame();
  });
  it("It start by asking you to think of an animal", function() {
    expect(message[0]).toEqual(think_of_an_animal);
    expect(message[1]).toEqual(is_elephant_question );
  });
  it("It wins if you thought of an elephant", function(){
    quiz.answer("y");
    expect(message[2]).toEqual(i_win_message);
  });
  it("It looses if you did not think of an elephant", function() {
    quiz.answer("n");
    expect(message[2]).toEqual(you_win_message);
  });
  it("It learns when it looses", function() {
    quiz.answer("n");
    expect(message[3]).toEqual(what_animal_question);
    quiz.answer("a rabbit");
    expect(message[4]).toEqual("Give me a question to distinguish a rabbit from an elephant.");
    quiz.answer("Is it a small animal?");
    expect(message[5]).toEqual("For a rabbit, what is the answer to your question?  (y or n)");
    quiz.answer("y");
    expect(message[6]).toEqual("Thanks.");
     
  });
 
  it("It wins if you thought of a dog", function(){
    quiz.answer("n");
    expect(message[3]).toEqual(what_animal_question);
    quiz.answer("a dog");
    expect(message[4]).toEqual("Give me a question to distinguish a dog from an elephant.");
    quiz.answer("Is it a small animal?");
    expect(message[5]).toEqual("For a dog, what is the answer to your question?  (y or n)");
    quiz.answer("y");
    expect(message[6]).toEqual("Thanks.");
  });
});