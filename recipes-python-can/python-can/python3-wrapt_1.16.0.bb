
SUMMARY = "Module for decorators, wrappers and monkey patching."
HOMEPAGE = "https://github.com/GrahamDumpleton/wrapt"
AUTHOR = "Graham Dumpleton <Graham.Dumpleton@gmail.com>"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dc34cbad60bc961452eb7ade801d25f7"

SRC_URI = "https://files.pythonhosted.org/packages/95/4c/063a912e20bcef7124e0df97282a8af3ff3e4b603ce84c481d6d7346be0a/wrapt-1.16.0.tar.gz"
SRC_URI[md5sum] = "3e370b4bc08f7dcc518cf8895673b19c"
SRC_URI[sha256sum] = "5f370f952971e7d17c7d1ead40e49f32345a7f7a5373571ef44d800d06b1899d"

S = "${WORKDIR}/wrapt-1.16.0"

RDEPENDS_${PN} = ""

inherit setuptools3
