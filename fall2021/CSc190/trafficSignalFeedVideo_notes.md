# Traffic Signal Feed Video Notes

[Link to video](https://drive.google.com/file/d/1Kpk-vbGusfSPwJfP5dvF1AsfR1DiVsMF/view?usp=sharing)  

Will be used to create a data unit for all data from traffic signal. Will store the data in a specific format.  
SPAT: Signal Phase and Timing  
Phase: Signals go through phases throughout time in a regular pattern. Expressed in ring and phase diagram which shows compatible phases. Has a barrier to show compatible phases.  

Will have to create map of intersection, assign phase numbers to allowed movements.  

For min and max time, fill in null time.  
For Bits 210-215, fill in phase status values. Will give us info on how to do it.  
Will transform the signals from videos to the above bits.  
Data will be sent every 100ms.  
Will want us to do the same for pedestrian movements (walk, don't walk, etc.)  
Our project will be mainly getting the phase status values and pedestrian status values  

Will assign each lane as phase# controlled by signal group #. Label all phase and signal groups first, then make diagram.  

Every 100ms, camera gets a view, analyzes, and sends the data.  

Additional Thoughts: Can we make intersection templates that we can search through instead of making each from scratch? Input list lanes in set pattern, search for it to see if the layout has been made already?  

Left northbound: 1  
straight/o right southbouth: 2  
Left Eastbound: 3  
straight/o right westbound: 4  
Left southbound: 5  
Straight/o right northbound: 6  
Left westbound: 7  
Straight/o right Eastbound: 8
