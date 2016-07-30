# FragmentAnimations

[![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html)
<img src="https://img.shields.io/badge/license-Apache 2.0-green.svg?style=flat">
[![API](https://img.shields.io/badge/API-4%2B-yellow.svg?style=flat)](https://android-arsenal.com/api?level=4)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-FragmentAnimations-green.svg?style=true)](https://android-arsenal.com/details/1/3526)

Animation examples for `support.v4.Fragment` transition.

These animations do not depends on any external libraries.

[<img src="https://dply.me/h7azvd/button/large" alt="Try it on your device via DeployGate">](https://dply.me/h7azvd)

## Usage Example

In your `Fragment`, just code like this.

```java
@Override
public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
    return CubeAnimation.create(CubeAnimation.UP, enter, DURATION);
}
```

See more example in [ExampleFragment.java](https://github.com/kakajika/FragmentAnimations/blob/master/app/src/main/java/com/labo/kaji/fragmentanimations/example/ExampleFragment.java)

## Contents

### Cube Animation

[CubeAnimation.java](https://github.com/kakajika/FragmentAnimations/blob/master/fragmentanimations/src/main/java/com/labo/kaji/fragmentanimations/CubeAnimation.java)

![Cube](https://raw.githubusercontent.com/wiki/kakajika/FragmentAnimations/images/cube.gif)

### Flip Animation

[FlipAnimation.java](https://github.com/kakajika/FragmentAnimations/blob/master/fragmentanimations/src/main/java/com/labo/kaji/fragmentanimations/FlipAnimation.java)

![Flip](https://raw.githubusercontent.com/wiki/kakajika/FragmentAnimations/images/flip.gif)

### Push/Pull Animation

[PushPullAnimation.java](https://github.com/kakajika/FragmentAnimations/blob/master/fragmentanimations/src/main/java/com/labo/kaji/fragmentanimations/PushPullAnimation.java)

![Push/Pull](https://raw.githubusercontent.com/wiki/kakajika/FragmentAnimations/images/pushpull.gif)

### Sides Animation

[SidesAnimation.java](https://github.com/kakajika/FragmentAnimations/blob/master/fragmentanimations/src/main/java/com/labo/kaji/fragmentanimations/SidesAnimation.java)

### Move Animation

[MoveAnimation.java](https://github.com/kakajika/FragmentAnimations/blob/master/fragmentanimations/src/main/java/com/labo/kaji/fragmentanimations/MoveAnimation.java)

![Move](https://raw.githubusercontent.com/wiki/kakajika/FragmentAnimations/images/move.gif)

## Combination

You can use above Animations with another one.

```java
@Override
public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
    if (enter) {
        return MoveAnimation.create(MoveAnimation.UP, enter, DURATION);
    } else {
        return CubeAnimation.create(CubeAnimation.UP, enter, DURATION);
    }
}
```

### Cube/Move Animation

![Cube/Move](https://raw.githubusercontent.com/wiki/kakajika/FragmentAnimations/images/cubemove.gif)

### Move/Cube Animation

![Move/Cube](https://raw.githubusercontent.com/wiki/kakajika/FragmentAnimations/images/movecube.gif)

### Push/Move Animation

![Push/Move](https://raw.githubusercontent.com/wiki/kakajika/FragmentAnimations/images/pushmove.gif)

### Move/Pull Animation

![Move/Pull](https://raw.githubusercontent.com/wiki/kakajika/FragmentAnimations/images/movepull.gif)

## Install

This library is available in jcenter.

```groovy
dependencies {
    compile 'com.labo.kaji:fragmentanimations:0.1.1'
}
```

## License

    Copyright 2015 kakajika

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
