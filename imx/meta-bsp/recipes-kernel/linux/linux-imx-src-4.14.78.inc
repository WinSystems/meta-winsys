# Copyright 2017-2018 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

SRCBRANCH = "master_imx_4.14.78"
LOCALVERSION = "-${SRCBRANCH}"
KERNEL_SRC ?= "git://github.com/WinSystems/c444-winsys-linux-imx.git;protocol=https"
SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH}"
SRCREV = "72bff255c02c7862d924ac0fa4df1b7bad2a64cb"

S = "${WORKDIR}/git"
