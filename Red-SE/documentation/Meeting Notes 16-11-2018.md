# Meeting Notes 16-11-2018.md
## n.1.1 Meeting Objectives
  1. Dealing with documentation: make use of markdown files stored in git.
  2. We need to convert previous meeting notes to this format. 
  3. Discuss the interview -> create a plan for what we will do over this sprint.
  4. Review of our code so far. [DONE]
  5. Learning about GitHub: merging branches. [DONE]
  6. Assign `story points` to features in `product backlog`.
  7. Create `Definition of Done`.

## n.1.2 Sprint Review 
  1. Review of our code so far. 
  2. Created a branch called `code-comments`: we refactored the classes, and added comments to futher understanding of the code base.
  3. Create Pull Request of `code-comments` branch -> merge to master.
  4. Completed Trello Tasks:
    1. Make main character walk in 4 directions [DONE]
    1. Pair Programming: Solve a CodeWars Challenge to practice TDD [DONE]
    1. Research Current trends in Game Design, researching games that have features that we would like in our game [DONE]
    1. Research LibGDX: installing the software [DONE]
    1. Level Design: Create a basic level. [DONE]
    1. LibGDX content should be under Git Version Control in the following repo: https://github.bath.ac.uk/jsw37/Red-SE [DONE]
    1. Aim to have a basic LibGDX set-up guide with required resources and a basic template  [DONE]
    1. Aim to create a first draft in LibGDX on Monday that matches the first prototype. [DONE]
    1. Defining Definition of Done [DONE]
  5. Incomplete Backlog in Trello, any impediments?:
    1. Standardise CW2 Documentation that we have generated so far: 
      1. being "Agile" about what this will look like. We nowe have a better idea, and will be able to retrospectivly update the meeting notes and documentation. 
      1. Solution: Use of a markdown template
      1. Template in a wiki
      1. We will use pandocs or other converter to transform markdown to latex.
    2. Set up Travis CI
      1. how to make use of two project intialisers is a problem.
      1. make use of https://start.spring.io/ to generate a CI project.
    3. Find a good main character sprite image:
      1. wasn't a priority. We now have a better idea of what it should look like.
    4. Other impediment to project: health and other coursework deadlines add complications.
  6. reviewed last weeks interview presentation and considered valuable feature to implement.

## n.1.3 Backlog Management
  ### n.1.3.1 Update Trello (Note: take screenshot before and after)
  Created Wiki pages for Important Project Wide Information:
    1. Code of Conduct
    1. Coursework Specification
    1. Definition of Done
    1. Licence
    1. Meeting Note Template
## n.1.4 Sprint Retrospective (applying the methodology)
1. Listen to interview and see how we can improve on the previous sprint.
2. Restuctured how we write our documentation will speed up future meetings and impose better structure.
3. Adopt `Fibonacci numbering` for sprint tasks.
4. Decided to implement `Definition of Done` 
5. Use of a wiki for project wide considerations.
6. Pair programming: what did we think about the experience?
  1. Learning TDD using pair programming was useful.
  1. Using questions from `codewars.com` was useful.
  1. We used pair programming to build the game, we would like to continue to do this.
7. Use of laptop -> large screen projection so the group can view the work together simultaneously.
8. It will be easier to delegate specific implementations now that we have a 'base' project.
9. The time we have on Fridays is very useful, we will continue to meet in this time.

## n.1.5 Past Interview/User Story Discussion
1. Challenge: happy with the challenge, but cautious: we need to focus on strategy rather than tactics
2. Challenge: don't make the game chaotic: don't just make it about "mashing" buttons.
3. Challenge: make it about "solving" a puzzle.
4. Concern: don't have too many enemies, a variety of enemies is better than a large quantity.
5. Game progression: levels should lead from one to the next 1 -> 2 -> 3... with difficulty progressing: "Take the user on a story"
6. Tutorial: as new concepts get introduced, a tutorial embedded in the level will be displayed with information.
7. Level completion: how to measure level completion: completion time, number of moves, lives lost, enemies killed, etc...
8. Unlocking levels: based on performance.
9. Unlocking characters: not a central idea.
10: Items: added later on in the game as it progresses.
11: Experience.
12: Main menu: Single player, Multiplayer, Settings, Tutorial/Instructions, Awards, Exit.
13: In-level menu: Restart, Main Menu, Quit, Settings, Instructions, Save.
14: Settings: Volume control, character selection, full-screen mode.
15: Tutorial/Instructions: a list of all for the main menu, specific tutorial at start of level.

## n.1.6 Brainstorming
1. Destroying walls?
1. Pulling boxes out of corners?
1. Unlocking characters
1. HUD?
1. Items to add in the game

## n.1.7 Next Week's Customer Questions
TBD

## n.1.8 Sprint Tasks -> Kanban board
1. Jonny will copy/paste the template in the first weeks of notes, and then allocate other team members to complete the tasks.
2. Trello Tasks should be numbered with format <week>.<task>
3. Add Code of Conduct: Open Source Game Developers on Github...
4. Add License: look at MIT?
5. Code: map: From Tiled .tmx files -> String format.
6. Code: enemy: add a new type of enemy that you have to trap
7. Code: menu: creation of a Main menu
8. Code: 2nd player: add a sencond player to the game: different image, can walk through boxes.
9. Start on writing the documentation for the game.
10. Level design: 1st, 2nd and 3rd level that progress in a story mode.
11. Add git workflow as a wiki
12. Session on Markdown
