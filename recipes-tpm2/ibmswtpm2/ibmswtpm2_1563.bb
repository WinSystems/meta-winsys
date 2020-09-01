SUMMARY = "IBM's Software TPM 2.0"
LICENSE = "BSD"
SECTION = "securty/tpm"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=1e023f61454ac828b4aa1bc4293f7d5f"

DEPENDS = "openssl"

SRC_URI = "https://sourceforge.net/projects/ibmswtpm2/files/ibmtpm${PV}.tar.gz \
           file://remove_optimization.patch \
           "
SRC_URI[md5sum] = "13013612b3a13dc935fefe1a5684179c"
SRC_URI[sha256sum] = "fc3a17f8315c1f47670764f2384943afc0d3ba1e9a0422dacb08d455733bd1e9"

S = "${WORKDIR}/src"

LDFLAGS = "${LDFALGS}"

do_compile () {
   make CC='${CC}'
}

do_install () {
   install -d ${D}/${bindir}
   install -m 0755 tpm_server  ${D}/${bindir}
}
