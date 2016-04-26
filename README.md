# FragmentAnimations
Animation examples for `support.v4.Fragment` transition.

[<img src="https://dply.me/h7azvd/button/large" alt="Try it on your device via DeployGate">](https://dply.me/h7azvd)

These animations do not depends on any external libraries.

## Usage Example

In your `Fragment`, just code like this.

```java
@Override
public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
    return CubeAnimation.create(CubeAnimation.UP, enter, DURATION);
}
```

See more example in [ExampleFragment.java](https://github.com/kakajika/FragmentAnimations/blob/master/app/src/main/java/com/labo/kaji/fragmentanimations/ExampleFragment.java)

## Contents

### Move Animation

[MoveAnimation.java](https://github.com/kakajika/FragmentAnimations/blob/master/app/src/main/java/com/labo/kaji/fragmentanimations/animation/MoveAnimation.java)

![Move](https://raw.githubusercontent.com/wiki/kakajika/FragmentAnimations/images/move.gif)

### Cube Animation

[CubeAnimation.java](https://github.com/kakajika/FragmentAnimations/blob/master/app/src/main/java/com/labo/kaji/fragmentanimations/animation/CubeAnimation.java)

![Cube](https://raw.githubusercontent.com/wiki/kakajika/FragmentAnimations/images/cube.gif)

### Flip Animation

[FlipAnimation.java](https://github.com/kakajika/FragmentAnimations/blob/master/app/src/main/java/com/labo/kaji/fragmentanimations/animation/FlipAnimation.java)

![Flip](https://raw.githubusercontent.com/wiki/kakajika/FragmentAnimations/images/flip.gif)

### Push/Pull Animation

[PushPullAnimation.java](https://github.com/kakajika/FragmentAnimations/blob/master/app/src/main/java/com/labo/kaji/fragmentanimations/animation/PushPullAnimation.java)

![Push/Pull](https://raw.githubusercontent.com/wiki/kakajika/FragmentAnimations/images/pushpull.gif)

### Sides Animation

[SidesAnimation.java](https://github.com/kakajika/FragmentAnimations/blob/master/app/src/main/java/com/labo/kaji/fragmentanimations/animation/SidesAnimation.java)

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

