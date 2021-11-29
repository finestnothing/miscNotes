# Traffic Light Identification and Classification Project

- [Traffic Light Identification and Classification Project](#traffic-light-identification-and-classification-project)
  - [Dataset](#dataset)
  - [Installing Yolov5](#installing-yolov5)
  - [Training](#training)
    - [Additional Required Folders](#additional-required-folders)
    - [Install Yolov5](#install-yolov5)
    - [How to Train](#how-to-train)
  - [Detecting Traffic Lights](#detecting-traffic-lights)
    - [Requirements](#requirements)
    - [Command to run](#command-to-run)

## Dataset

[https://hci.iwr.uni-heidelberg.de/content/bosch-small-traffic-lights-dataset](https://hci.iwr.uni-heidelberg.de/content/bosch-small-traffic-lights-dataset)

## Installing Yolov5

- git clone https://github.com/ultralytics/yolov5
- cd yolov5
- pip -r requirements.txt

## Training

### Additional Required Folders

- Datset/
  - test/
    - images/
    - labels/
  - train/
    - images/
    - labels/
  - val/
    - images/
    - labels/
- All images from Bosch dataset [https://hci.iwr.uni-heidelberg.de/content/bosch-small-traffic-lights-dataset](https://hci.iwr.uni-heidelberg.de/content/bosch-small-traffic-lights-dataset)
  - rgb/
    - train/
      - base folders go here

### Install Yolov5

[Install Yolov5](#installing-yolov5)

### How to Train

To train model, run the trafficLightID.ipynb file. It will automatically split up data into the train, val, and test folders and run the correct command to train and test the model.

For 200 epochs on 500 images resized to 736x736, the model will take ~11 hours to train but it is accurate. Currently saved in the 200epoch500img folder.

## Detecting Traffic Lights

### Requirements

[Install yolov5](#installing-yolov5) if not already cloned

### Command to run

```bash
cd yolov5
python3 detect.py --weights (path/to/weights.pt) --source (path/to/folder, path/to/file, url, or 0 for webcam) --img (resolution, 640 or 720 recommended) --conf (confidence threshold for detection, 0.25 or higher recommended) --save-txt
cd ..
```

Will output a folder under yolov5/runs/detect/ with annotated images and txt files for each stoplight
