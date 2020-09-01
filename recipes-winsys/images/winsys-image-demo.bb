DESCRIPTION = "WinSystems Image to validate machines. \
This image contains everything used to test machines including GUI, \
demos and lots of applications. This creates a very large image, not \
suitable for production."
LICENSE = "MIT"

require dynamic-layers/qt5-layer/recipes-fsl/images/imx-image-full.bb

### WARNING: This image is NOT suitable for production use and is intended
###          to provide a way for users to reproduce the image used during
###          the validation process of C444 BSP releases.

CORE_IMAGE_EXTRA_INSTALL += " \
	iperf3 \
	ffmpeg \
	hdparm \
	packagegroup-core-buildessential \
	htop \
	stress-ng \
	glmark2 \
	coreutils \
	util-linux \
	util-linux-hwclock \
	wget \
	packagegroup-security-tpm2 \
	u-boot-imx-fw-utils \
	less \
	nano \
"
