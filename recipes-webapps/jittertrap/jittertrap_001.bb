SUMMARY = "A network delay, jitter and loss test and measurement tool"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8264535c0c4e9c6c335635c4026a8022"

SRCREV = "${AUTOREV}"
PR = "r0"
PV = "001+git${SRCPV}"
SRC_URI = "git:///mnt/devel/git-repos/jittertrap.git"

S = "${WORKDIR}/git"

do_compile() {
   make
}

do_install() {
   install -d ${D}/usr/bin/
   install -m 0744 ${S}/src/jittertrap ${D}/usr/bin/

   install -d ${D}/var/lib/jittertrap/
   install -m 0644 ${S}/static_content/* ${D}/var/lib/jittertrap/
}
