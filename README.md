# Activity lifecycle, Intent, Broadcast receivers, and Notifications example.

In this example you will see how to register, unregister and send a broadcast receiver as well as how to move from one activity to another.

- We move to another activity using Intents that can be explicit and implicit;

Explicit – Specifies the exact component it wants to start
Implicit – Does not specify the component, however, it must include enough information for the system to deduce which components can receive that type of intent.

- Here we also can see what is the lifecycle of an actvity and how that will perform when we change form 1 to another activity.

How to set you intent to change the activity:
- Step 1: Create Intent like so: val intent: Intent = Intent(context: Context, ClassName:class)
- Step 2: Add data to intent via extras. Here you should define the tags to identify the data (because extras act like key-value pairs in a dictionary or Map)
- Step 3: Pass intent to the class (activity) you want to start.
- Step 4: Call the method startActivity(Intent)
- Step 5: Make sure that you have the identifiers for the extras as public so that the started activity can use it to retrieve the data

Activity lifecycle:
Opening the activity
- onCreate()
- onStart()
- onResume()

Closing the app
- onPause()
- onStop()

Reopening the app
- onRestart()
- onStart()
- onResume()

