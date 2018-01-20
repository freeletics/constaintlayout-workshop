# Animations

### Overview

The user interface of an activity often changes in response to user input and other events. For example, an activity that contains a form where users can type search queries can hide the form when the user submits it and show a list of search results in its place.

To provide visual continuity in these situations, you can animate changes between different view hierarchies in your user interface. These animations give users feedback on their actions and help them learn how your app works.

Android includes the transitions framework, which enables you to easily animate changes between two view hierarchies. The framework animates the views at runtime by changing some of their property values over time. The framework includes built-in animations for common effects and lets you create custom animations and transition lifecycle callbacks.

We will focus on animations inside single view, so called `delayed transitions`.

### Simple transitions

Simplest use case of `delayed transitions` is shown below

```
    boolean visible;

    @Override
    public void onClick(View v) {
        TransitionManager.beginDelayedTransition(transitionsContainer);
        visible = !visible;
        text.setVisibility(visible ? View.VISIBLE : View.GONE);
    }
 ```

![simple animation](../../../../../img/simple-animation.gif)

[andkulikov](https://medium.com/@andkulikov/animate-all-the-things-transitions-in-android-914af5477d50)

Constraint layout gives a opportunity to adjust whole
layout of the view by changing only few parameters

####simple constraint layout animation example with video

### Constraint Set

`Constraint Set` allows you to define programmatically
a set of constraints to be used with ConstraintLayout.
It lets you create and save constraints,
and apply them to an existing ConstraintLayout.
ConstraintsSet can be created in various ways:

* Manually
`c = new ConstraintSet(); c.connect(....);`
* from a R.layout.* object
`c.clone(context, R.layout.layout1);`
* from a ConstraintLayout
`c.clone(clayout);`

Here are some examples

####layout animation
####video

### Custom transition, Interpolator

Custom transition and non-linear interpolator could be applied on `delayed transitions` as well

####example of custom transaction and interpolator
####video