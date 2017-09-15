# AirQuickUtils
AirQuickUtils provides a wide range of functions.<br/>
Text, SharedPreferences, image, network, time, location (scheduled), logs, encryption, consolidation <br/>
Various features such as SNS login (scheduled) can be used as a single library.<br/>
<br/>
<br/>
# Features Included
## [Api Document Link](http://www.mowa.kr/airquickutil/)
- AirLog
- AirPrefs
- AirScreen
- AirSdcard
- AirShare
- AirString
- AirSystem
- AirValidation
- AirWebView
- ~~AirNetwork~~(scheduled)
- ~~AirSecurity~~(scheduled)
- ~~AirSnsLogin~~(scheduled)
- ~~AirAnimation~~(scheduled)
- ~~AirDateTime~~(scheduled)
- ~~AirImage~~(scheduled)
- ~~AirLocation~~(scheduled)
<br/>
<br/>

# Setup

### 1.Include the library as local library project.
```gradle
 scheduled
```
<br/><br/>

### 2. Add Initialization into your Application class
```java
  AirQuickUtils.init(this);
```
<br/><br/>

# Usage
### How to use AirPref.
##### set SharedPreferences.
```java
  AirQuickUtils.prefs.save("KEY_NAME" , "String Value");
  AirQuickUtils.prefs.save("KEY_NAME" , true);
  AirQuickUtils.prefs.save("KEY_NAME" , 10);
  AirQuickUtils.prefs.save("KEY_NAME" , 10f);
  AirQuickUtils.prefs.save("KEY_NAME" , 10L);
```
#### get SharedPreferences.
```java
  AirQuickUtils.prefs.getString("KEY_NAME" , null);
  AirQuickUtils.prefs.getBoolean("KEY_NAME" , false);
  AirQuickUtils.prefs.getInt("KEY_NAME" , 0);
  AirQuickUtils.prefs.getFloat("KEY_NAME" , 0f);
  AirQuickUtils.prefs.getLong("KEY_NAME" , 0L);
```

<br/>

### How to use AirLog.
```java
  AirQuickUtils.log.d("LOG MESSAGE");
```
<br/>


<br/>

### How to use AirWebView.
```java
    AirWebViewOption webViewOption = new AirWebViewOption();
    webViewOption.setUrl("http://www.mowa.kr");
    webViewOption.setTitle("TEST WEB VIEW");
    webViewOption.setShowActionbar(false);
    webViewOption.setShowUrl(false);
    AirQuickUtils.webview.startAirCommonWebView(webViewOption);
```

<br/>

### How to use AirSystem. [Class AirQuickUtils.system](http://www.mowa.kr/airquickutil/yongbeom/utils/airquickutils/AirQuickUtils.system.html)
```java
  AirQuickUtils.system.getDeviceUUID();
```

<br/>

### How to use AirScreen. [Class AirQuickUtils.screen](http://www.mowa.kr/airquickutil/yongbeom/utils/airquickutils/AirQuickUtils.screen.html)
```java
  AirQuickUtils.screen.getScreenDensity();
```


<br/>

### How to use AirSdcard. [Class AirQuickUtils.sdcard](http://www.mowa.kr/airquickutil/yongbeom/utils/airquickutils/AirQuickUtils.sdcard.html)
```java
  AirQuickUtils.sdcard.createTempDir();
```



# License

    Copyright 2017 LeeYongBeom

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
