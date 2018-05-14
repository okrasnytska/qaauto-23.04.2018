# User guide for first software installation

####**Downloading:**
1. Google → “InetlliJ IDEA download” → JetBrains link *(1st link)* → Community version *(free)* → download.
2. File explorer → This PC → right click → Properties: look if you have 32 or 64 bit OS
3. Google → “jdk” → Oracle site → “download” --> if 32bit Windows → jdk 7 → if 64bit → jdk 10 *(last one)* → Accept license agreement → choose OS → "download"
4. Google --> "Mozilla Firefox download" --> first site --> "download" or upload to a new version

####**Installation:**
Run installers 1, 3, 4 from downloading → click “Next” ***(don't change anything!)***

####**Customization:**
1. Run IntellijIDEA → Choose theme
2. “New project” → “Maven” tab → SDK *(on top)* → choose folder with JDK → “Next”
3. Initialization:
- GroupID is *“com.qastartup”*
- ArtifactID is *“qaauto-23.04.2018”*
- Project name is *“qaauto-23.04.2018”*
- Folder - better not to change and remember it

####Linking tools
1. Google --> "maven selenium java" --> link to mvnrepository.com --> copy "dependency" text
open pom.xml file of project --> under "version" insert tags "<dependencies> </dependencies>" --> between this tags insert copied selenium dependency
2. Google --> "Geckodriver download" --> unzip file 
geckodriver file copy --> folder c:/Windows/system32 --> paste file
3. Google --> mvnrepository testNG --> copy dependency for maven --> paste under selenium dependency

####Git Commit & upload:

1. Create new repository at the GIThub (Enter repository name)
2. Copy link to repository  
3. Enable version control integration in IDE (VCS  => enable version control integration)
4. Add link to IDE : VCS => GIT => Remotes
5. At the IDE select VCS => "Commit..."
6. At the "Commit Changes" window choose needed files and folders
7. Enter commit text that describes changes
8. Select VCS => Git => "Push"
9. Click on "add origin" link and enter repo url from step 2
10. Press "Push" button

###That's all! You are ready to code!