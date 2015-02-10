var menuCurrentlyOpen = new Array();
var menuCurrentlyInsideID;
var menuCurrentlyInsideIsTopLevel;
var menuCurrentlyInsideLevel
var menuItemCurrentlyInsideID;
var menusReady;
var req;

function menuInitPosition() {
  /*@cc_on @*/




  menusReady = true;
}

function menuMouseDown() {
  if (!menusReady)
  return;
  if (menuCurrentlyInsideID != null) {
  // Mouse clicked inside of menu-title
  if (menuCurrentlyInsideIsTopLevel) {
  // menu-title is in top level menu
  if (menuCurrentlyOpen[0] == null) {
  // Currently no menu open: Open the clicked menu
  menuCurrentlyOpen[0] = document.getElementById(menuCurrentlyInsideID);
  menuCurrentlyOpen[0].style.visibility = "visible";
  } else {
  // Currently a menu already open: Close it, but leave the current menu-title highlighted
  menuHide(0);
  menuHighlight(menuCurrentlyInsideID, true);
  }
  }
  } else {
  // Mouse clicked outside of a menu-title: Close any open menus
  menuHide(0);
  }
  // Mouse clicked inside of menu item: Execute this item
  switch (menuItemCurrentlyInsideID) {
  case "sub" :
  self.location.href="a";
  break;
  case "lists" :
  self.location.href="b";
  break;
  case "prefs" :
  self.location.href="c";
  break;
  case "login" :
  self.location.href="d";
  break;
  case "logout" :
  self.location.href="e";
  break;
  }
}

function menuIn(level, menuID) {
  menuHighlight(menuID, true);      // highlight the current menu-title
  menuCurrentlyInsideID = menuID;      // remember which one this is
  menuCurrentlyInsideIsTopLevel = level == 0;
  menuCurrentlyInsideLevel = level;
  if (level > 0 || menuCurrentlyOpen[0] != null) {
  // Currently a menu already open: Check which one this is
  menuCurrentlyInside = document.getElementById(menuCurrentlyInsideID);
  if (menuCurrentlyInside != menuCurrentlyOpen[level]) {
  // Currently open menu is a different one: Close it, and open the current menu instead
  menuHide(level);
  menuCurrentlyOpen[level] = menuCurrentlyInside;
  menuCurrentlyOpen[level].style.visibility = "visible";
  }
  }
}

function menuOut(level, menuID) {
  if (menuCurrentlyOpen[level] == null)    // if no menu is currently open:
  menuHighlight(menuID, false);     // remove its highlight
  menuCurrentlyInsideID = null;      // remember that we are now not 'inside' of a menu-title
}

function menuItemIn(level, menuItemID) {
  menuHighlight(menuItemID, true);     // highlight current menu-item
  menuItemCurrentlyInsideID = menuItemID;    // remember which one this is
  menuCurrentlyInsideLevel = level;
  if (level > 0 & menuCurrentlyOpen[level] != null) {
  // If not on top-level and currently a menu open: Close it
  menuHide(level);
  }
}

function menuItemOut(level, menuItemID) {
  menuHighlight(menuItemID, false);     // remove highlight of menu-item
  menuItemCurrentlyInsideID = null;     // remember that we are now not 'inside' of a menu-item
}


function menuHide(level) {
  if (menuCurrentlyOpen[level] != null) {
  // If a menu is open: remove highlight and close it and all sub-menus
  menuHighlight(menuCurrentlyOpen[level].id, false);
  menuCurrentlyOpen[level].style.visibility = "hidden";
  menuCurrentlyOpen[level] = null;
  menuHide(level + 1);
  }
}

function menuHighlight(menuItemID, highlightOn) {
  if (highlightOn)
  document.getElementById(menuItemID + ".cell").className = "pulldownMenuItemHighlight";
  else
  document.getElementById(menuItemID + ".cell").className = "pulldownMenuItem";
}

function menuGetLeft(menuObj) {
  menuLeftPos = 0;
  while (menuObj) {
  if (menuObj.offsetLeft)
  menuLeftPos += menuObj.offsetLeft;
  menuObj = menuObj.offsetParent;
  }
  return menuLeftPos;
}

function menuGetTop(menuObj) {
  menuTopPos = 0;
  while (menuObj) {
  if (menuObj.offsetTop)
  menuTopPos += menuObj.offsetTop;
  menuObj = menuObj.offsetParent;
  }
  return menuTopPos;
}

function loadXMLDoc(url) {
  req = false;
  // branch for native XMLHttpRequest object
  if(window.XMLHttpRequest) {
  try {
  req = new XMLHttpRequest();
  } catch(e) {
  req = false;
  }
  // branch for IE/Windows ActiveX version
  } else if(window.ActiveXObject) {
  try {
  req = new ActiveXObject("Msxml2.XMLHTTP");
  } catch(e) {
  try {
  req = new ActiveXObject("Microsoft.XMLHTTP");
  } catch(e) {
  req = false;
  }
  }
  }
  if(req) {
  req.onreadystatechange = processReqChange;
  req.open("GET", url, true);
  req.send("");
  }
}

function subform() {
   document.forms[0].submit();
}

function windowUp(URL,h) {
   day = new Date();
   id = day.getTime();
   window.open (URL, id,'toolbar=0,scrollbars=1,location=0,statusbar=0,menubar=0,resizable=yes,width=600,height=' + h + ' ');
}

function confirmOpt(prompt) {
   input_box=confirm(prompt);
   if (input_box==true) {
   return true;
   } else {
   return false;
   }
}

function autoFocus(a,b) {
   if (document.getElementById(a)) {
   if (document.getElementById(a).value) {
   if (document.getElementById(b)) {
   document.getElementById(b).focus();
   }
   } else {
   document.getElementById(a).focus();
   }
   }
}