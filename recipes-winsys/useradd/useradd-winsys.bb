SUMMARY = "Adds the user win"
DESCRIPTION = "Recipe for adding the default user win to the image"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://rs485-config.c \
           file://rs485-config \
           file://rs422uart1 \
           file://rs422uart2 \
           file://rs485uart1 \
           file://rs485uart2"


S = "${WORKDIR}"

inherit useradd

DEPENDS = " weston weston-init "

RDEPENDS_${PN} = " bash weston weston-init "
# You must set USERADD_PACKAGES when you inherit useradd. This
# lists which output packages will include the user/group
# creation code.
USERADD_PACKAGES = "${PN}"

# You must also set USERADD_PARAM and/or GROUPADD_PARAM when
# you inherit useradd.

# USERADD_PARAM specifies command line options to pass to the
# useradd command. 
USERADD_PARAM_${PN} = "-u 1200 -d /home/win -r -s /bin/bash -P 'winsys' -G video,weston-launch,sudo winsys;"

do_install () {
        install -d -m 755 ${D}${datadir}/winsys
	install -d -m 755 ${D}/home/winsys/serial-scripts/

	install -p -m 644 rs485-config.c ${D}/home/winsys/serial-scripts/
	install -p -m 755 rs485-config ${D}/home/winsys/serial-scripts/
	install -p -m 755 rs422uart1 ${D}/home/winsys/serial-scripts/
	install -p -m 755 rs422uart2 ${D}/home/winsys/serial-scripts/
	install -p -m 755 rs485uart1 ${D}/home/winsys/serial-scripts/
	install -p -m 755 rs485uart2 ${D}/home/winsys/serial-scripts/

        chown -R winsys:winsys ${D}${datadir}/winsys
        chown -R winsys:winsys ${D}/home/winsys

}

FILES_${PN} = "${datadir}/winsys /home/winsys"


# Prevents do_package failures with:
# debugsources.list: No such file or directory:
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
