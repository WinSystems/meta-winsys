# WinSystems C444 Yocto Layer README

Welcome to the official GitHub repository for the WinSystems C444 Yocto Layer. This layer is specifically designed for building images for the [WinSystems ITX-P-C444 Board](https://www.winsystems.com/product/itx-p-c444/) and the SYS-C444 system.

## Features

- **Target Board Support:** Tailored for the WinSystems ITX-P-C444 and SYS-C444.
- **Desktop Environment:** Comes with a Wayland Desktop for a smooth graphical experience.
- **Wireless Connectivity:** Integrated support for Intel WiFi cards.
- **CAN BUS Support:** Includes InoDisk CAN BUS drivers and utilities.
- **Kernel and Bootloader Versions:** Built on kernel 5.15.15 and U-BOOT 2022.

## Documentation

- **[BSP Documentation](https://github.com/WinSystems/c444-manifest/wiki):** Detailed Board Support Package documentation for various versions.
- **[Yocto Build Guide](https://github.com/WinSystems/c444-manifest/wiki/Yocto-Build-Guide-5.15):** Comprehensive build instructions for the Yocto Project layers.
- **[Image Usage & Configuration](https://github.com/WinSystems/c444-manifest/wiki/Image-Usage):** Guidelines on accessing U-Boot, switching device trees, Linux boot media, and more.
- **[Device Interfacing](https://github.com/WinSystems/c444-manifest/wiki/GPIO):** Information on GPIO, UARTs, RS232/485/422, and interfacing through libgpio and GPIOD.

## Development Machine Requirements

- Minimum 8GB of memory
- 315GB of available disk space
- Ubuntu 20.04 or equivalent

## Quick Start Guide

1. **Install Dependencies:**
   ```bash
   sudo apt update && sudo apt upgrade
   sudo apt install gawk wget git-core diffstat unzip texinfo gcc-multilib build-essential chrpath socat libsdl1.2-dev xterm sed cvs subversion coreutils texi2html docbook-utils python-pysqlite2 help2man make gcc g++ desktop-file-utils libgl1-mesa-dev libglu1-mesa-dev mercurial autoconf automake groff curl lzop asciidoc u-boot-tools python
   ```

2. **Set Up Environment:**
   ```bash
   mkdir ~/winYocto
   git config --global user.name "Your Name"
   git config --global user.email "Your Email"
   mkdir ~/bin
   curl https://storage.googleapis.com/git-repo-downloads/repo > ~/bin/repo
   chmod a+x ~/bin/repo
   export PATH=~/bin:$PATH
   ```

3. **Download Yocto Project Layers:**
   ```bash
   cd ~/winYocto
   repo init -u https://github.com/WinSystems/c444-manifest.git -b 5.15 -m itx-p-c444_5.15.32.xml
   repo sync
   ```

4. **Build the Image:**
   ```bash
   MACHINE=imx8mq-itx-p-c444 DISTRO=c444-xwayland source winsys-setup-release.sh -b build
   ulimit -n 10000
   bitbake -k winsys-image-demo
   ```

   _Note: Follow the detailed steps in the [Yocto Build Guide](https://github.com/WinSystems/c444-manifest/wiki/Yocto-Build-Guide-5.15) for a successful build._

## Support

For assistance with the ITX-P-C444, contact WinSystems, Inc:

- **Phone:** +1.817.274.7553
- **Website:** [www.winsystems.com](https://www.winsystems

.com)
- **Email:** [techsupport@winsystems.com](mailto:techsupport@winsystems.com)

## Contributing

Contributions to this Yocto layer are welcome. Please read our [contribution guidelines](CONTRIBUTING.md) for details on how to submit patches, bug reports, and feature requests.

## License

This Yocto layer is provided under [LICENSE](LICENSE.md). By using, distributing, or contributing to this project, you agree to the terms and conditions of this license.

## Acknowledgements

This layer has been developed and maintained by the WinSystems team, with contributions from the open-source community. We would like to thank all contributors for their valuable input and dedication to the project.

---