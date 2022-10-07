FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI:append = " file://imx8mq-itx-p-c444.dts"

do_configure:append(){
 cp ${WORKDIR}/imx8mq-itx-p-c444.dts ${S}/arch/arm64/boot/dts/freescale/
 echo "dtb-$(CONFIG_ARCH_MXC) += imx8mq-itx-p-c444.dtb" >> ${S}/arch/arm64/boot/dts/freescale/Makefile
}