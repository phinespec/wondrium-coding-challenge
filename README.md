# wondrium-coding-challenge

The purpose of this challenge is to gauge your skills and knowledge of Android
development and coding style in (Java or Kotlin or BOTH).
Here is an endpoint that returns JSON objects.
1. https://rokudev.azurewebsites.net/homeitems
This endpoint will return a list of items. Take the data from these items and
display them on the screen in a usable fashion ( horizontal trays, list, etc) displaying the
course image. These items contain a course number of which the image can be found
by replacing the course id in the following string:
https://secureimages.teach12.com/tgc/images/m2/wondrium/courses/{courseId}/
portrait/{courseId}.jpg
2. After you have displayed these items, if you click on one you should then make the
following call and display the data that is returned in whatever fashion you want using
Android Material UI toolkit or any custom UI. The only requirement is that the data is
displayed and you also display the list of lectures returned in the JSON
https://rokudev.azurewebsites.net/details
3. When you click on any of the lectures you should then play a video using the
following stream URLs in Exoplayer or any free third party player that can handle m3u8,
m3u, or mp4:
https://cdn.flowplayer.com/a30bd6bc-f98b-47bc-abf5-97633d4faea0/hls/
de3f6ca7-2db3-4689-8160-0f574a5996ad/playlist.m3u8
http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/
BigBuckBunny.mp4
http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/
ForBiggerBlazes.mp4
This is a timed assignment and from the time you receive the email, you will have 4
hours to complete.
The app should have 3 screens, one for the home screen, one for details, and one for
the video player, showcasing you custom/native, UI skills, and task completion abilities.
Submission
Send the completed challenge to me at charityd@teachco.com or on a Github page .
The submission package should include the full Android project (compressed).
Good Luck!!!
