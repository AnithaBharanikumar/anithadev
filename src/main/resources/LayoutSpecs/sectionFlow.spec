@objects
    cnnredlogo     css    div.container a.logo
    headernav      css    nav.js-navigation
    headercont     css    nav.js-navigation div.container
    bucketsnav     css    .buckets.drawer
    z-container    css    .pg-no-rail > div.l-container
    zones-*        css    .pg-no-rail section.zn
    zone-cont-*    css    .pg-no-rail section.zn > .l-container
    zoneHeader-*   css    .l-container > div > h2

= Header =
    @on Mobile
        headernav:
            width 95 to 100 % of screen/width

    @on Desktop, Tablet
        headernav:
            width 100 % of screen/width

= Zones =
    z-container:
        aligned vertically centered headercont
 
    zoneHeader-*:
        aligned vertically centered z-container
    
    @forEach [zones-*] as zoneName, , next as nextZone
        ${zoneName}:
            above ${nextZone} -2 to 5 px