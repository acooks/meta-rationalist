require libwebsockets.inc

PV = "1.7"

PRIORITY = "10"

LIC_FILES_CHKSUM ??= "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRCREV = "1b2c9a23e13dd250b193e4302a8d48c5be97d16b"
SRC_URI += "git://github.com/warmcat/libwebsockets"

BBCLASSEXTEND += " native "
