# InternetSaathi\onboarding-sdk 



Installing Onboarding SDK

In order to install the SDK add the following in your build.gradle file:
```gradle
	android {
	    compileOptions {
	        sourceCompatibility JavaVersion.VERSION_1_8
	        targetCompatibility JavaVersion.VERSION_1_8
	    }
	}

	dependencies {

	        implementation 'com.frend:assistednavigation:0.1.1'
	}
```

First of all, you need to allow your application to have access to the internet and define its name. In your AndroidManifest.xml file, add the following:
```manifest
<manifest
  ...
  >
  
	<uses-permission android:name="android.permission.INTERNET" />
	<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
	<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
</manifest>
```

In your Application class, initialize the SDK with your Parse application, journey, languageCode:
```java
public class App extends Application {

  // Initializes SDK as soon as the application is created
  @Override
  public void onCreate() {
    super.onCreate();


    CustomAssistant.init(this, journey , languageCode);

  }
}
```
After creating our Application class, we need to define its name on the AndroidManifest.xml file, as follows:
```manifest
<manifest package="<YOUR_PACKAGE_NAME>"
  ...
  >
  <application
    android:name=".App"
    ...>
    ...
  </application>
```

To download the audio files, add the following in Main/Starting activity. Make sure you are requesting for WRITE_EXTERNAL_STORAGE permissions before downloading the audio:

```java
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
        }
        CustomAssistant.offlineDownload(this);
    }
}
```

Further, store config file in json format in the assets folder

Format :

```xml
{
  "languageCode": {
    "journey": {
      "pulse": true,
      "showOnlyWhenAudio": true,
      "journey": [
        {
          "text": "Text_to_be_displayed",
          "audioUrl": "Url_of_the_audio_file",
          "activity": "name_of_the_activity",
          "view": "name_of_the_view",
          "audioPath": "name_of_audio_file_store_in_raw_folder"
        }
      ]
    }
  }
}
```
Example :
```xml
{
  "en": {
    "on_boarding": {
      "pulse": true,
      "showOnlyWhenAudio": true,
      "journey": [
        {
          "text": "Click here to Select English Language",
          "audioUrl": "https://ypvnxx00-a.akamaihd.net/mp3/f-tc-49360.mp3",
          "activity": "MainActivity",
          "view": "english_text_view",
          "audioPath": "english"
        }
      ]
    }
  }
}
```
Note : Audio's to be played locally should be stored in raw folder of the application.
