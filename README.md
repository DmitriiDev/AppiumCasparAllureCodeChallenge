In my task I Used a native UI testing tool Appium. It’s a black box testing tool. I implemented test architecture with the ScreenObject Pattern (mobile analog of PageObject). This approach has both strengths and weaknesses.

Strengths: • it’s a black box. You can emulate exactly the same behavior of a user as it happens in the real life. • You don’t need to have much knowledge for writing such tests. Any Testers who have a little knowledge of how to code can use it. • Appium provides a recording tool. You can find a quick solution from the record of your interaction with the app.

Weaknesses: • Your tests don’t isolate. Your environment depends on the internet connection, states of the previous test run, old data. That why you can’t trust the tests on 100% • Tests are very slow. Appium lives in a separate app(server) and it should sync with the app after each interaction. Looks like this is the main reason why we have delay while training screen. It’s very time-consuming and the time for such interaction isn’t constant. It means that you don’t know the expected result - in the end, you have not reliable tests.

From my point of view android UI tests should be implemented via Espresso for android and EarlGray for iOS. Just because we can’t covered whole scenarios by such tests. I guess we can use this framework only for checking the most critical path of user stories.

Opinion about app: From my point of view the app has too many screens.

Main mission of the app:

Provide list of exercises for recovery
Show the example “How to do” these exercise.
Second mission:

Provide additional information about health
Therapist-Chat
Background mission:

Walking tracker.
sync with wearable devices and health services
From this perspective I can conclude that the most valuable function is “My Training”

“My Training” Screen has next major functions:

“I’m Ready” Button Exercise Screen: - Start the exercise
- Video Player. Pause/Play/ - Start/Skip Button - Instruction/Settings Exercise Run Screen: - timer - receptions counter - indicator of Sets - Pause/Start button - Skip - Close
The most important happy path for the user is next:

Open “My Training” screen
Tap “I’m Ready” Button
Tap “Start” Button
Check That Video Playback
Timer is run
The exercise can be completed.
