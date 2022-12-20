SUMMARY = "Adds the user winsys"
DESCRIPTION = "Recipe for adding the default user winsys to the image"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://gpio_test.py \
        file://rs422uart1.py \
        file://rs422uart2.py \
        file://rs485-config \
        file://rs485-config.c \
        file://rs485uart1.py \
        file://rs485uart2.py"

S = "${WORKDIR}"

inherit useradd

DEPENDS = " weston weston-init python3"

RDEPENDS:${PN} = " bash weston weston-init python3"
# You must set USERADD_PACKAGES when you inherit useradd. This
# lists which output packages will include the user/group
# creation code.
USERADD_PACKAGES = "${PN}"

# You must also set USERADD_PARAM and/or GROUPADD_PARAM when
# you inherit useradd.

# USERADD_PARAM specifies command line options to pass to the
# useradd command. 
USERADD_PARAM:${PN} = "-u 1200 -d /home/winsys -r -s /bin/bash -p '6trgP06JrYXSM' -G video,weston-launch,sudo winsys;"

do_install () {
        install -d -m 755 ${D}${datadir}/winsys
	install -d -m 755 ${D}/home/winsys/serial-scripts/

	install -p -m 644 rs485-config.c ${D}/home/winsys/serial-scripts/
	install -p -m 755 rs485-config ${D}/home/winsys/serial-scripts/
	install -p -m 755 rs422uart1.py ${D}/home/winsys/serial-scripts/
	install -p -m 755 rs422uart2.py ${D}/home/winsys/serial-scripts/
	install -p -m 755 rs485uart1.py ${D}/home/winsys/serial-scripts/
	install -p -m 755 rs485uart2.py ${D}/home/winsys/serial-scripts/
	install -p -m 755 gpio_test.py ${D}/home/winsys/

        chown -R winsys:winsys ${D}${datadir}/winsys
        chown -R winsys:winsys ${D}/home/winsys

}

FILES:${PN} = "${datadir}/winsys /home/winsys"
# Prevents do_package failures with:
# debugsources.list: No such file or directory:
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
