# Sandwich Club Project Starter Code

## General Overview

This repo contains all the work done for the **Sandwich Club** of the Udacity's Android Developer Nanodegree. The goal of this project is to complete the  **Sandwich Club** app to
show the details of each sandwich once it is selected. For more details about this see [Sandwich Club app starter code.](https://github.com/udacity/sandwich-club-starter-code)

## Application description

The application shows a series of different sandwiches to the user. Then once a sandwich is selected, detailed information about it is shown to the user. See [Application details](https://github.com/acasadoquijada/sandwich-club#application-details) for more info about this For technical details see work_done section

## Screenshots

![mainActivity](doc/images/sandwich_selection_resized.jpg) ![detailActivity](doc/images/sandwich_details_resized.jpg) 

## Application details

* In [DetailActivity.java](https://github.com/acasadoquijada/sandwich-club/blob/master/app/src/main/java/com/udacity/sandwichclub/DetailActivity.java) two methods have been created:
	*  [_populateUI_](https://github.com/acasadoquijada/sandwich-club/blob/master/app/src/main/java/com/udacity/sandwichclub/DetailActivity.java#L70<) to populate the UI with the sandwich information
	* [_populateUIList_](https://github.com/acasadoquijada/sandwich-club/blob/master/app/src/main/java/com/udacity/sandwichclub/DetailActivity.java#L97) helper method used in _populateUI_ 
	
* [JsonUtils.java](https://github.com/acasadoquijada/sandwich-club/blob/master/app/src/main/java/com/udacity/sandwichclub/utils/JsonUtils.java) the [constructor](https:/-/github.com/acasadoquijada/sandwich-club/blob/master/app/src/main/java/com/udacity/sandwichclub/utils/JsonUtils.java#L23) creates a correct Sandwich object with the information obtained from a JSON within a String. It takes into account the possibility of empty data (such as no place of origin or aka)

* [activity_detail.xml](https://github.com/acasadoquijada/sandwich-club/blob/master/app/src/main/res/layout/activity_detail.xml) has been reorganized and added the possibility to scroll
