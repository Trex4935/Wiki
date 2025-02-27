
# How to SysID  

## Prerequisites  
1. Ensure that the [template code](https://github.com/Trex4935/Wiki/blob/main/Training/example.java) is in your subsystem.  
2. In `robot`, under `teleop init`, add the following line:  
   ```java
   signalLogger.setPath("/media/sda1/ctre-logs/");
   ```  

## Testing  
### Setup  
- Plug a USB drive into one of the RIO ports—this is where the logs will be stored.  

### Log Collection  
1. Start log collection by pressing **POV Right** on the controller.  
2. Use **X** until it stops, then switch to **B** until it stops.  
3. Be careful with **A** and **Y**—it will stall initially but then ramp up in speed quickly. Release the button when it gets "too fast."  
4. Save the logs by pressing **POV Left**.  

## Extracting Logs  
1. Open **Tuner** and go to **Tools > Log Extractor**.  
2. In the file explorer, click **Connect** and paste the path:  
   ```
   /media/sda1/
   ```  
3. Open the `log` folder and download the log file.  
4. Convert the log:  
   - Click **Convert**.  
   - Select **WPI LOG** as the output type.  
   - Ensure all flags are highlighted.  
   - Click **Convert** again.  

## Loading Logs in SysID  
1. Open **SysID** and load the converted logs.  
2. Drag the `xx_sysid` file into the **Data Selector**.  
3. Expand **Phoenix 6** and **Motor** folders.  
4. In the **Data Panel**, map the following:  
   - **Velocity → Velocity**  
   - **Position → Position**  
   - **Supply Voltage → Voltage**  
5. Click **Load Data**—you should now see charts and data.  

## Interpreting Logs  
- Review the extracted data.  
- Note the **Kp** value and add it to **Tuner**.  
- That should complete the process!  


