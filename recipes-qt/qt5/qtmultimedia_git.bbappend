
do_install_append() {
    install -d ${D}${OE_QMAKE_PATH_PLUGINS}/videoeglvideonode
    install -d ${D}${OE_QMAKE_PATH_PLUGINS}/videoimx6vivantevideonode 
}
FILES_${PN} += "${OE_QMAKE_PATH_PLUGINS}/videoeglvideonode"
FILES_${PN} += "${OE_QMAKE_PATH_PLUGINS}/videoimx6vivantevideonode"
