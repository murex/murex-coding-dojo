think_of_an_animal = "Think of an animal ...";
is_elephant_question = "Is it an elephant? (y/n)";
you_win_message = "You win.  Help me learn from my mistake before you go...";
what_animal_question= "What animal were you thinking of?";
distinguish = "Give me a question to distinguish a rabbit from an elephant.";
i_win_message = "I win.  Pretty smart, aren't I?";
play_again = "Play again?  (y or n)";

newQuiz = function (callback) {
  var print = callback;
  var yesOrNo = function(message) {
       if(message === "n") {
         print (you_win_message);
         print (what_animal_question);
         nextAnswer = learnNewAnimal;
       } else {
         print (i_win_message)
       }
  }
  var smallOrNot = function(message) {
     print ("Thanks.");
  }
  var nextAnswer = yesOrNo;
   
  var learnNewAnimal = function(animal) {
     print ("Give me a question to distinguish " + animal+ " from an elephant.");
     nextAnswer = function(message){
        askAQuestion(message, animal)
    };
  };
  var askAQuestion = function(message, animal) {
      print ("For "+  animal + ", what is the answer to your question?  (y or n)");
      nextAnswer = smallOrNot;
       
  };
 
  return {
    startGame : function() {
       print (think_of_an_animal);
       print (is_elephant_question );
    },
    answer : function(message) {
      nextAnswer(message);
    }
  };
};