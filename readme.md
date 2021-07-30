## GPTabLayout

Ground pound TabLayout

This sideProject is for fun .

[![sample]()](https://user-images.githubusercontent.com/51425629/127620578-b18fe837-2541-4bf5-8d7b-4f36f10d3301.mp4)


### Download

----

##### in build.gradle
```
allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
	}
}
```
#### if android studio version is beta or preview
##### in settings.gradle
```
dependencyResolutionManagement {
    ...
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```
##### last in build.gradle(app)

```
dependencies {
        implementation 'com.github.EndRollModel:GPTabLayout:0.0.1'
}
```

### how to use

---

#### if you use with viewpager2
##### java
```java
GPTabLayout gpTab = findViewById(R.id.gpTabLayout);
ViewPager2 vp = findViewById(R.id.viewpager2);
gpTab.setData(vp, new GPItemInfo() {
    @Override
    public void selectView(int index, TextView textView) {
        textView.setText(String.valueOf(index));
    }
});
```
##### kotlin
```kotlin‍‍‍‍‍‍
val gpTab = findViewById<GPTabLayout>(R.id.gpTabLayout)
val vp = findViewById<ViewPager2>(R.id.viewpager2)
vp.adapter = FragmentAdapter(this)

gpTab.setData(vp) { index, textView ->
    textView.text = index.toString()
}
```
------
#### other
##### java
```java
gpTab.setListener(new GPTabSelectedListener() {
    @Override
    public void selectedIndex(int index) {
        // here can get click tab index do something
    }
});
 gpTab.setData("one", "two", "three");
```
##### kotlin
```kotlin
gpTab.setListener(GPTabSelectedListener {
    // here can get click tab index do something
})
gpTab.setData("one", "two", "three")
```

-------------

#### Image resource from [walfie gif](https://walfiegif.wordpress.com/)

若有侵權行為請告知 我會盡快處理 謝謝
