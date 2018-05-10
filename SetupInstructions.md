# User guide for first software installation

####**Downloading:**
1. Google → “InetlliJ IDEA download” → JetBrains link *(1st link)* → Community version *(free)* → download.
2. File explorer → This PC → right click → Properties: look if you have 32 or 64 bit OS
3. Google → “jdk” → Oracle site → “download” --> if 32bit Windows → jdk 7 → if 64bit → jdk 10 *(last one)* → Accept license agreement → choose OS → "download"
4. Google --> "Mozilla Firefox download" --> first site --> "download" or upload to a new version
5. Google --> "Geckodriver download" --> unzip file 
6. Google --> "maven selenium java" --> link to mvnrepository.com --> copy "dependency" text

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
- open pom.xml file of project --> under "version" insert tags "<dependencies> </dependencies>" --> between this tags insert copied selenium dependency
- geckodriver file copy --> folder c:/Windows/system32 --> paste file



###That's all! You are ready to code!