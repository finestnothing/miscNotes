# CSc 180 Project 3

Group:

Alec Resha (Solo)

Due 10/28/2021

## Problem Statement

The main goal of this project is to analyze and categorize images.
The CIFAR-10 dataset was used to obtain images of 10 different things. These were: ['airplane', 'automobile', 'bird', 'cat', 'deer', 'dog', 'frog', 'horse', 'ship', 'truck']. The images come in 32x32 pixel size.

This dataset allows training of neural networks since all images are labelled.

The VGG16 model was also used to process images. The model is classified as a deep model since it has 16 distinct layers, and often gets a high accuracy when compared to other models with fewer layers.

## Methodology

Convolutional Neural Networks were used to analyzing the images. The images were first split into training and testing data for use with fitting the models.

In order to make inputs more compatible, both models resize the images before training them. All labels were converted to one-hot categorical arrays.

For converting VGG16 to a sequential model, the documentation was referenced extensively.

## Experimental Results and Analysis

For the self-defined model, it had a total of 2 Conv2D layers, 2 maxPooling layers, 1 Dense layer, and 1 dense output layer. This resulted in an accuracy of 0.64. This could be improved through the addition of more layers, but most of the time was spent on the VGG model.

## Task Division and Project Reflection

Project done solely by me.  

The next biggest challenge was formatting the data, resizing the x arrays was time consuming and getting the loop correct took a lot of variations. An indexing loop kept getting out of bounds exceptions. The main formatting challenge was making the data fit into the VGG model since it kept throwing a cardinality error.

The second biggest challenge was figuring out the VGG model section. This was solved by double checking the lectures, then google the different methods available for combining sequential and functional.
The available documentation for the model also helped immensely.

I definitely learned a lot from this program, the image identification will be a big plus for the final project. This will also be a great reference tool while working on it since it covers a lot of the issues I saw with CNN.
