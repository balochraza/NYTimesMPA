# NYTimesMPA
App to hit the NY Times Most Popular Articles API and:
If Network is not available app show Toast message for check connection
Shows details on item click from list.
We'll are using the most viewed section of this API. http://api.nytimes.com/svc/mostpopular/v2/mostviewed/{section}/{period}.json?apikey= sample-key To test this API, For testAPI we used
all-sections for the section path component in the URL
7 for period
We used MVC Design pattern and java generic approach to develop this application. 

We are generating TestCase and Coverage report using two tools, you can opt out any one as per your connivance:

__. Espresso for Unit Test__

__. Jacoco for Coverage Reports__ 

__App Flow__

__Article List Screen__

![alt text](https://github.com/balochraza/NYTimesMPA/blob/master/ScreenShots/Screenshot_1560956642.png)

__Article Detail Screen__

![alt text](https://github.com/balochraza/NYTimesMPA/blob/master/ScreenShots/Screenshot_1560956651.png)

# Libraries

[Picasso](https://square.github.io/picasso/) Images add much-needed context and visual flair to Android applications. Picasso allows for hassle-free image loading in your application—often in one line of code.

[RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview) display a scrolling list of elements based on large data sets (or data that frequently changes).

[OkHttp](https://square.github.io/okhttp/) HTTP is the way modern applications network. It’s how we exchange data & media. Doing HTTP efficiently makes your stuff load faster and saves bandwidth.

[Retrofit](https://square.github.io/retrofit/) is a type-safe HTTP client for Android and Java.

[Gson Converter](https://github.com/square/retrofit/tree/master/retrofit-converters/gson) A Converter which uses Gson for serialization to and from JSON.

# Installation
Installation by cloning the repository
Open Project from Android Studio
Build Gradle and simply run the project

# Code Coverage Report 
open from build/reports/coverage/index.html

# Create new Coverage Report 
1)Click on Gradle Icon from right Panel 
2)Click run Gradle Task and write the command "createDebugAndroidTestCoverageReport" in command line.

# Code Unit Test 
Go to src/androidTest/java/com.nytarticlesmpa/Activities.
Select MainActivityTest.java
Press ctrl+shfit+R or right click on MainActivityTest.java and click on Run MainActivityTest





