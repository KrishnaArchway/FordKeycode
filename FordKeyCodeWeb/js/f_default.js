var NS4 = (document.layers);
var IE4 = (document.all);

function popupWindow( popupURL, popupWindowName ) {
  window.open(popupURL,popupWindowName,'menubar=no,scrollbars=yes,dependent=yes,resizable=yes,toolbar=no,status=no,width=600,height=550');
}

function MM_preloadImages() { //v3.0
  var d=document; 
  if(d.images){ 
    if(!d.MM_p) d.MM_p=new Array();
    var i,j = d.MM_p.length, a = MM_preloadImages.arguments;
    for(i=0; i<a.length; i++)
      if (a[i].indexOf("#")!=0){ 
        d.MM_p[j]=new Image;
        d.MM_p[j++].src=a[i];
      }
   }
}

function MM_findObj(n, d) { //v3.0
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
  d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}

  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];

  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document); return x;
}

function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
  if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}

function quoteReplace(psString) {
  var lsRegExp = /'/g;
  return String(psString).replace(lsRegExp, "''");
}

/* vasu
function submitFrmCatalog(pid,pdsc,rid,rname) {
        
	document.frmCatalog.pid.value = pid;
	document.frmCatalog.pdsc.value= pdsc;
	document.frmCatalog.repLevelID.value = rid;
	document.frmCatalog.divisionName.value= rname;
	document.frmCatalog.action="catalog.jsp";
	document.frmCatalog.submit();
} vasu
*/
function submitFrmCatalog(repCatIDs,repCatNames) {
        
	document.frmCatalog.repCatIDs.value = repCatIDs;
	document.frmCatalog.repCatNames.value= repCatNames;
	document.frmCatalog.action="catalog.jsp";
	document.frmCatalog.submit();
}


/*
 * New method written to replace submitfrmB(stk,nid).  The afore mentioned
 * method relied on a form named croot to exist on all content pages in order
 * for the order summary level item detail functionality to work.  This was
 * very redundant and caused for confusion.  All calls will now reference a
 * single form in the leftNav.jsp file.
 *
 * param stknum   The item stock number the detail is for.
 * param nomid    The nomenclature id for this item in the database.
 * param frmtype  A flag used to determine which page the product detail should
 *                provide a link back to.
 * param desc     Description to use for the return link
 * param criteria Any criteria information that will be needed by the page
 *                returned to.
 */
function showProductDetail(stknum, nomid, frmtype, desc, criteria) {
        document.frmShowProductDetail.frmtype.value=frmtype;
	document.frmShowProductDetail.desc.value=desc;
	document.frmShowProductDetail.criteria.value=criteria;
        document.frmShowProductDetail.stkno.value=stknum;
	document.frmShowProductDetail.nomenclatureid.value=nomid;
	document.frmShowProductDetail.submit();
} 


/*
 * overloaded method for the previous method
 * new param added which is "isProcessed"  
 *
 * param isProcessed  to determine if the processing of the order is done or not yet 
 */

function showProductDetail(stknum, nomid, frmtype, desc, criteria, isProcessed ) {
        document.frmShowProductDetail.frmtype.value=frmtype;
	document.frmShowProductDetail.desc.value=desc;
	document.frmShowProductDetail.criteria.value=criteria;
        document.frmShowProductDetail.stkno.value=stknum;
	document.frmShowProductDetail.nomenclatureid.value=nomid;
	document.frmShowProductDetail.isProcessed.value=isProcessed ; 
	document.frmShowProductDetail.submit();
} 


// This method should eventually be replaced with showProductDetail.  This
// method still exists in interest of avoiding broken links in code.
function submitfrmB(stk,nid) {
	showProductDetail(stk, nid, '', '', '');
}

function shoppingCart(nid,action) {
	document.croot.actiontype.value=action;
	document.croot.nomenclatureid.value=nid;
	document.croot.action="showCart.jsp";

  if (action == 'remove') {
	  var response = confirm("Are you sure you want to remove this item?");
		if (response == true) {
	    document.croot.submit();
		}
	} else if (action == 'empty') {
	  var response = confirm("Are you sure you want to remove all of the items?");
		if (response == true) {
	    document.croot.submit();
		}
	} else {
	  document.croot.submit();
	}
}

function addFromCatalog(href, nid) {
  reg = /\*/g;
	rep = "\'";
	
	reg1 = / & /g;
	rep1 = "%20%26%20";
	
	h=href.replace(reg,rep);
	h=h.replace(reg1,rep1);

	document.croot.actiontype.value="add";
	document.croot.nomenclatureid.value=nid;
	document.croot.action=h;
	document.croot.submit();
}



function updateCartFromSubmit(nid, action) {
  document.croot.actiontype.value=action;
	document.croot.nomenclatureid.value=nid;
	
  if (action == 'remove') {
	  var response = confirm("Are you sure you want to remove this item?");
		if (response == true) {
	    document.croot.submit();
		}
	} else {
	  document.croot.submit();
	}
}

function addItemToList(nid,action)

{
   document.additem.nomenclatureid.value=nid;
   document.additem.currentAction.value=action;
   document.additem.action="templateOrdersView.jsp";
   document.additem.submit();
 }
   
 function deleteItem(nid,action,lid,desc)
 {
    var askFor = confirm("Are you sure you want to remove this item?");
    if (askFor == true)
      {
            document.frmshow.nomenclatureid.value=nid;
            document.frmshow.currentAction.value=action;
            document.frmshow.listID.value=lid; 
            document.frmshow.listDesc.value=desc;
						document.frmshow.action="templateOrdersView.jsp";
            document.frmshow.submit();
      }
  }
  
/* This function is called in distributionCreateNewContent.jsp and distributionUpdateBPContent.jsp.*/
function submitFrmTemp(lid, desc)
 {
	   document.frmTemp.listID.value = lid;
           document.frmTemp.listDesc.value = desc;
           document.frmTemp.action="distributionView.jsp";
	   document.frmTemp.submit();
}
	

function submitfrmMainCatalog(rid,cdsc) {
	document.croot.repLevelID.value=rid;
	document.croot.cdsc.value=cdsc;
	document.croot.action="catalog.jsp";
	document.croot.submit();
}

function delFromBasket(nid)
{
   document.delFromBasket.nomenclatureid.value=nid;
	 document.delFromBasket.submit();
}


function isInteger(Number)
{
	Digits='0123456789';

	for(i=0;i < Number.length; ++i)
	{
	 if(Digits.indexOf(Number.charAt(i))==-1)
			{
				return false;
			}
    }
	 return true;
}

function slashCount(rnum)
{
	 cnt=0;
	  for(i=0;i < rnum.length; ++i)
		  if(rnum.charAt(i) == '/')
				cnt=cnt+1;

	  return cnt;
}

function isValidDate(vdate)
{
	var val = vdate;
	var dt=new Array();
	var flag = 0;

if( slashCount(val) == 2 )
{
  dt = val.split('/');
	var mm = parseInt(dt[0])
	var dd = parseInt(dt[1])
	var yy = parseInt(dt[2])


  if( (!(isInteger(dt[0]))) || 
	    (!(isInteger(dt[1]))) || 
      (!(isInteger(dt[2]))) )
		{
		 flag=1;
		}

   else
       {
		if( dt[0] == "08" )
		       mm=8;

		if( dt[0] == "09" )
		       mm=9;

		if( dt[1] == "08" )
		       dd=8;
		if( dt[1] == "09" )
		       dd=9;

		if( ((" "+dt[2]).length) != 5 )
				flag=1;
		else
			{
				if( ( yy < 1000) || (yy > 9999) )
					flag=1;
			}

		if ( (mm > 12) || (mm < 1) )
			{
			 flag=1;
			}


		if(dd < 1)
			{
				flag = 1;
			}
		else
			{
				if( (mm == 1) || (mm == 3) || (mm == 5) || (mm == 7) || (mm == 8) || (mm 
== 10) || (mm == 12) )
					{
						if( dd > 31)
							flag = 1;

					}
				else
					{
    					if( (mm == 4) || (mm == 6) || (mm == 9) || (mm == 11) )
							{
								if( dd > 30)
									flag = 1;
							}
						else

							if((yy % 4) == 0 )
								{

									if( (yy % 100) == 0)
										{
											if( ((yy / 100) % 4) == 0)
												{
													if( (mm == 2) && (dd > 29))
														flag = 1;
												}
											else
												{
													if( (mm == 2) && (dd > 28))
														flag = 1;
												}
										}
									if((mm == 2) && (dd > 29))
										flag = 1;
								}
							else
								{
									if( (mm == 2) && (dd > 28))
									flag = 1;
								}
						}
			}
		}
}

else
   flag=1;

   if(flag)
     return false;
	return true;
}




