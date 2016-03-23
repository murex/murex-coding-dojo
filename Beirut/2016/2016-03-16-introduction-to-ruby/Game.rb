class Game
  correctNumber = rand(0..9)
  guess = -1

  while guess != correctNumber
    puts 'Guess a number'
    guess = gets.to_i()

    if guess==correctNumber
      puts 'CORRECT GUESS!!!'
    else
      if guess < correctNumber
        puts 'Pick a bigger Number'
      else
        puts 'Pick a smaller Number'
      end
    end
  end

end