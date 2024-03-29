# Copyright 2017-2022 NXP
 
DEPENDS = "zlib-native openssl-native"

SRCBRANCH = "lf-5.15.32_2.0.0"
IMX_MKIMAGE_SRC ?= "git://source.codeaurora.org/external/imx/imx-mkimage.git;protocol=https"
IMX_MKIMAGE_SRC ?= "git://github.com/WinSystems/imx-mkimage.git;protocol=https"
SRC_URI = "${IMX_MKIMAGE_SRC};branch=${SRCBRANCH} \
           file://0001-iMX8M-soc.mak-use-native-mkimage-from-sysroot.patch \
"
SRCREV = "a8bb8edb45492ac70b33734122a57aa8e38a20bd"
# SRCREV = "a6d2118356c18b1a4c4f2d29fad2c31af2fa5753""
S = "${WORKDIR}/git"

BOOT_TOOLS = "imx-boot-tools"
SYSROOT_DIRS += "/boot"
