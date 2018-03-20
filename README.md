# ImageLoader
一个可替换的图片加载库

## Usage
### Step 1
Add it in your root build.gradle at the end of repositories:
```groovy
  	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

### Setp 2
Add the dependency
```groovy
	dependencies {
	       compile 'com.github.fuxuanyang11:ImageLoader:1.0.0'
	}
```
### Step 3 (具体使用看示例)
```java
ImageLoaderManager.getInstance().defaultImage(imageView, url);
```
