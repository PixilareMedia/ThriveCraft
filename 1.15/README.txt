TERMS
workspace = the folder where you have the mdk stored
cmd = Command Prompt
PixelCore-API-MC-1.15.1 is located at https://github.com/PixilareGames/PixelCore/tree/master/1.15

UPDATEING FORGE MDK
01. Download the forge mdk that is the latest
02. Open it take all files/folders except the src folder and place them in your workspace
03. Open CMD cd to your workspace folder
04. Run "gradlew eclipse"
05. Wait till done
06. Run "gradlew genEclipseRuns"
07. Repeat steps 12-17 in the SETTING UP A FORE MDK WORKSPACE
08. If you use your own account redo the USING YOUR OWN MC ACCOUNT instructions
09. If you compile mods using the PixelCore mod redo setps 18-21 in the SETTING UP A FORGE MDK WORKSPACE



USING YOUR OWN MC ACCOUNT
01. Open the dropdown arrow by the green run button
02. Select "runConfiguration"
03. Go to the "Arguments" tab
04. Add in the "Program arguments" section "--username ForgeDev@MinecraftForge.net --password 12345IsABadPassword"
(Replace ForgeDev@MinecraftForge.net with your Email & 12345IsABadPassword with your password)
05. Hit apply
06. Hit run
07. Go into a world and see if you now show up as you now
(If it does not work you may have spelled a part of your login wrong)



SETTING UP A FORGE MDK WORKSPACE
01. get the version that is listed when this file is updated (forge-1.15.1-30.0.30)
02. open the cmd and go to the directory that you want the mod workspace in
03. drop the forge mdk & the stuff from the respostory in there
04. run "gradlew eclipse"
05. wait until done
06. run "gradlew genEclipseRuns"
07. wait until done
08. open eclipse selcet the folder that is one above the forge mdk stuff for the workspace
09. lauch into eclipse
10. go to File->OpenProjectsFromFileSystem
11. click directory choose the forge mdk folder then click finsh
12. go to Project->Properties
13. Find the "Java Build Path" option
14. Look at the "Libraries" tab and click "Add External JARs..."
15. Make sure you have PixelCore-API.jar downloaded and in a pace where you can find it
16. Navigate to the PixelCore-API.jar and selcet it then hit open
17. Now you may hit the "Apply and Close" button
--Beyond Here In The SETTING UP A FORGE MDK WORKSPACE Is If You Are Going TO Compile A Mod That Uses The PixelCore Mod--
18. Find The build.gradlew file in the workspace and open it in a text editor
19. Go down to about line 94
20. Go to the end of line 94 and push enter and add the following "compile files("You/File/Path/To/PixelCore-API-MC-1.15.1.jar")"
21. Save the build.gradlew and now you may compile mods useing the PixelCore mod
