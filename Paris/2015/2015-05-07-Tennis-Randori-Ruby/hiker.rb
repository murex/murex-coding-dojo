SCORES = ["0", "15", "30", "40"]
def score(player1, player2)
  score1 = single_score(player1)
  score2 = single_score(player2)
  if tie(player1,player2)
    if score_above_4(player1, player2)
      "deuce"
    else
      score1 + "-A"
    end
  elsif game_is_over(player1, player2)
    "win " + winner(player1, player2)
  elsif score_above_4(player1, player2)
    "ad " + winner(player1, player2)
  else
    score1 + "-" + score2
  end
end
def tie(player1, player2)
  player1 != 0 && player1 == player2
end
def score_above_4(player1, player2)
  4 <= [player1, player2].max
end
def game_is_over(player1, player2)
  score_above_4(player1, player2) and (player1 - player2).abs >= 2
end
def winner(player1, player2)
  if player1 < player2
    "out"
  else
    "in"
  end
end
def single_score(player)
  SCORES[player]
end