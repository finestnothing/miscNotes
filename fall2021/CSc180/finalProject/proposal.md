# Inclusion of Existing Traffic Signals in Smart City Infrastructure

## Type B: Application

## Alec Resha

### Description

The problem being addressed by this project would be the integration of existing traffic signals into future smart-city plans.
Existing traffic intersections do not send their traffic light data anywhere, many are controlled by a local mechanism for changing lights on a timer.
The future of smart cities hinges on them becoming more connected.
Currently, very few traffic intersections are able to communicate with eachother, and have to be partially or fully replaced in order to upgrade them.
My senior project is working on a smaller, cheaper, and easier solution to this, and we need a specifically made model for analyzing videos/images of stoplights to produce near real-time data (updated every 100ms) of multiple traffic lights in a single image.

### Motivation

This is an important topic since linking intersections together will reduce traffic delays, drive time, pollution, and other growing issues in cities.
This cannot be done without integrating current traffic lights or replacing them entirely.
The goal of a low cost way to integrate these intersections is to begin the process sooner since everyone will benefit as cities become more efficient.

We are in contact with people from the USDOT and CALTRANS for our project, and it is likely that our system will be used as a base for future innovation.
We also will be uploading data directly to a database that is already in use by intersections that were built to be connected to others.

### Data Set

I plan to use data from [https://hci.iwr.uni-heidelberg.de/content/bosch-small-traffic-lights-dataset](https://hci.iwr.uni-heidelberg.de/content/bosch-small-traffic-lights-dataset) for testing and training the model.
I will also use video captured by our project for manual testing.
Several video feeds are already set up for testing and training use, and we have the hardware to capture more if needed.

### Algorithm Design

The algorithm for this project is most likely to be a CNN for image classification, but this may change since we are using Intel Compute Sticks on Raspberry Pi Zeroes for image capturing and processing.
I will also compare CNN with and without transfer learning based on models from [https://keras.io/api/applications](https://keras.io/api/applications).

We have been unable to find an existing algorithm for outputting the data that we need, and we need one compatible with our specific hardware to keep it low cost and scalable.
Most algorithms will identiy a single traffic light, but we need to capture multiple traffic lights in one image, and get the classification of each.

### Evaluation Plan

This will be evaluated with a train/test data split as well as manually checking real-world results.
The model will be evaluated with precision, recall, accuracy, and F-measure.

### Task Division

All work for making the model will be done by me. I am the only one with experience with AI/ML.
For manual checking, the rest of the group may participate to get more manual checks completed.
