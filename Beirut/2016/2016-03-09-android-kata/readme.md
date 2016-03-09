###Date: 2016/03/09
###Source: [android-kata] Self organized
###Problem Description

####Android Kata
Workshop Description: 
The Kata will start with a brief introduction about the tools used for android development and the life cycle of an activity.
We will then write an application that fetches books details from Google books API and display them in a list. Whenever a book is clicked, its details will appear in a second activity.
In this second activity, you can like a book which will both save it to a SQLite database and broadcast an event that a book was liked.
This broadcast event is caught by the application itself and a message is displayed to the user.
A service will be running in the background which will update a progress bar on the main activity every second. 
By developing this application, we will be covering the following topics:
	Manifest file 
	Intent 
	Asynchronous calls
	Service with callback
	Content Provider
	Broadcast events
	Third libraries like Volley, Glide, RecyclerView..
The application will be tested both on a real device and an emulator (emulator might not fetch books from the network due to proxy configuration).

 
Session Outline:
Tools: IDE, SDK, Emulator, Gradle
Android Major Elements:
Activity (and its life cycle)
Service
Layouts
	process: declare in XML, initiate in runtime
	more flexibility where the presentation is seperated from code and we can have different layouts for different screens
	set the default labels, sizes, padding, margins
	2 major types of layouts (Linear and Relative)
	
Manifest File
	package name, activities, receivers, content providers, services
	permissions. Network, Internet, external read/write, etc.
	icon, app name, app theme
	
Intents
	Glue between activities
	Used to move the user from 1 screen to another
	Implicit intent
		to perform an action from other app
		it has actions like dial, maps,  webpage
	Explicit intents
		to launch activities, services and broadcast within the same app
		It has the data to be transferred
		
Application Development workflow
	Create the Timer Service
		Create the service and register it in the manifest
		implement callback to MainActivity
	Create books provider
		Create a provider that fetches the books
		Implement different behaviors when proxy is enabled/disabled
	Build the main activity list
		Add the recycler and item view layouts
		Create the recyclerView field in the main activity, attach a layout to it and set an an adapter for it
		create the adapter class to inflate the item layout and set its elements
	Make list item clickable
		make the item view in the adapter class clickable
		create a new activity and launch it onclick
	Create Like button to send broadcast and display toast
		Add the like button
		implement its onclick method to display a toast and send the book title as broadcast
		Implement the observer pattern to separate the 2 functionalities
	Create the broadcast receiver
	Create the content provider and access it


#Retrospective
5
5	A bit technical
5	 
5	 
5	The code crashed
5	 
5	 
5	 
