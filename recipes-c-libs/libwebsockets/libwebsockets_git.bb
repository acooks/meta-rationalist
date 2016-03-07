require libwebsockets.inc

PV = "1.7"

PRIORITY = "10"

LIC_FILES_CHKSUM ??= "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRCREV = "${AUTOREV}"
PR = "r1"
PV = "003+git${SRCPV}"

BRANCH = "v1.7-stable"
SRC_URI = "git://github.com/warmcat/libwebsockets;branch=${BRANCH};"

BBCLASSEXTEND += " native "
