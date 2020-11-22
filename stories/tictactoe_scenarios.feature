
Feature: Play tictactoe win
  As a game member, I want to play TicTacToe, So that I can win

  Scenario: Player who connects horizontal line first wins
    Given user browses to http://localhost:8080/tictactoe/
    When first move X is (1,1)
    When second move O is (1,2)
    When third move X is (2,1)
    When fourth move O is (2,3)
    When fifth move X is (3,1)
    Then winner is X

  Scenario: Player who connects vertical line first wins
    Given user browses to http://localhost:8080/tictactoe/
    When first move X is (2,1)
    When second move O is (1,2)
    When third move X is (2,3)
    When fourth move O is (3,3)
    When fifth move X is (2,2)
    Then winner is X

  Scenario: Player who connects diagonal top-down first wins
    Given user browses to http://localhost:8080/tictactoe/
    When first move X is (3,3)
    When second move O is (1,2)
    When third move X is (1,1)
    When fourth move O is (2,3)
    When fifth move X is (2,2)
    Then winner is X

  Scenario: Player who connects diagonal bottom-up first wins
    Given user browses to http://localhost:8080/tictactoe/
    When first move X is (1,3)
    When second move O is (1,2)
    When third move X is (3,1)
    When fourth move O is (2,3)
    When fifth move X is (2,2)
    Then winner is X



