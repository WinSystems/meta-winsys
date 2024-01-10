SUMMARY = "Kernel module for the EMUC B202 CAN BUS module"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "file://include/emuc_parse.h \
           file://include/transceive.h \
           file://emuc_parse.c \
           file://main.c \
           file://Makefile \
           file://transceive.c \
          "

DEPENDS = "virtual/kernel"
inherit module

S = "${WORKDIR}"

# FILES:${PN} += "/lib/modules/${KERNEL_VERSION}/extra/emuc2socketcan.ko"
RPROVIDES:${PN} = "kernel-module-emuc2socketcan"
KERNEL_MODULE_AUTOLOAD += "kernel-module-emuc2socketcan"