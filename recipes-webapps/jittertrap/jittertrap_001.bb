SUMMARY = "A network delay, jitter and loss test and measurement tool"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8264535c0c4e9c6c335635c4026a8022"

SRCREV = "${AUTOREV}"
PR = "r1"
PV = "001+git${SRCPV}"

#SRC_URI = "git:///mnt/devel/git-repos/jittertrap.git \
#           file://jittertrap.service"

BRANCH = "master"
SRC_URI = "git:///mnt/devel/git-repos/jittertrap.git;branch=${BRANCH} \
           file://jittertrap.service"


S = "${WORKDIR}/git"

inherit pkgconfig systemd

SYSTEMD_SERVICE_${PN} = "jittertrap.service"
SYSTEMD_AUTO_ENABLE_${PN} = "enable"

DEPENDS += "libnl"

do_compile() {
   ALLOWED_IFACES="Port1:Port2" make
}

do_install() {
   install -d ${D}/usr/bin/
   install -m 0744 ${S}/backend/jittertrap ${D}/usr/bin/

   install -d ${D}/var/lib/jittertrap/
   install -d ${D}/var/lib/jittertrap/fonts
   install -d ${D}/var/lib/jittertrap/css
   install -d ${D}/var/lib/jittertrap/js
   install -d ${D}/var/lib/jittertrap/templates
   install -m 0644 ${S}/frontend/output/fonts/* ${D}/var/lib/jittertrap/fonts/
   install -m 0644 ${S}/frontend/output/css/* ${D}/var/lib/jittertrap/css/
   install -m 0644 ${S}/frontend/output/js/* ${D}/var/lib/jittertrap/js/
   install -m 0644 ${S}/frontend/output/templates/* ${D}/var/lib/jittertrap/templates/
   install -m 0644 ${S}/frontend/output/index.html ${D}/var/lib/jittertrap/

   install -d ${D}${systemd_unitdir}/system
   install -m 0644 ${WORKDIR}/jittertrap.service ${D}${systemd_unitdir}/system
   sed -i -e 's,@BINDIR@,${bindir},g' ${D}${systemd_unitdir}/system/jittertrap.service
}
