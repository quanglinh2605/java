<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
    <meta http-equiv="Content-Type"
          content="text/html; charset=windows-1252" />
    <title>Flower Shop</title>

    <link rel="stylesheet" type="text/css" href="assets/css/style.css" />

</head>
<body>

    <div id="wrap">

        <div class="header">
            <div class="logo">
                <a href="home">
                    <img src="assets/images/logo.gif" alt="" title=""
                         border="0" />
                </a>
            </div>
            <div id="menu">
                <ul>
                    <li class="selected"><a href="home">home</a></li>
                    <li><a href="aboutus">about us</a></li>
                    <li><a href="category">flowers</a></li>
                    <li><a href="specials">specials gifts</a></li>
                    <li><a href="myaccount">my accout</a></li>
                    <li><a href="register">register</a></li>
                    <li><a href="details">prices</a></li>
                    <li><a href="contact">contact</a></li>
                </ul>
            </div>


        </div>


        <div class="center_content">
            <div class="left_content">
				<jsp:include page="${p}"></jsp:include>
            </div>
            <!--end of left content-->

            <div class="right_content">
                <div class="languages_box">
                    <span class="red">Languages:</span> <a href="#" class="selected">
                        <img src="assets/images/gb.gif" alt="" title="" border="0" />
                    </a> <a href="#">
                        <img src="assets/images/fr.gif" alt="" title=""
                             border="0" />
                    </a> <a href="#">
                        <img src="assets/images/de.gif" alt=""
                             title="" border="0" />
                    </a>
                </div>
                <div class="currency">
                    <span class="red">Currency: </span> <a href="#">GBP</a> <a href="#">EUR</a>
                    <a href="#" class="selected">USD</a>
                </div>


                <div class="cart">
                    <div class="title">
                        <span class="title_icon">
                            <img src="assets/images/cart.gif" alt=""
                                 title="" />
                        </span>My cart
                    </div>
                    <div class="home_cart_content">
                        3 x items | <span class="red">TOTAL: 100$</span>
                    </div>
                    <a href="cart" class="view_cart">view cart</a>

                </div>




                <div class="title">
                    <span class="title_icon">
                        <img src="assets/images/bullet3.gif"
                             alt="" title="" />
                    </span>About Our Shop
                </div>
                <div class="about">
                    <p>
                        <img src="assets/images/about.gif" alt="" title="" class="right" />
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
                        eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
                        enim ad minim veniam, quis nostrud.

                    </p>

                </div>

                <div class="right_box">

                    <div class="title">
                        <span class="title_icon">
                            <img src="assets/images/bullet4.gif"
                                 alt="" title="" />
                        </span>Promotions
                    </div>
                    <div class="new_prod_box">
                        <a href="details">product name</a>
                        <div class="new_prod_bg">
                            <span class="new_icon">
                                <img src="assets/images/promo_icon.gif"
                                     alt="" title="" />
                            </span> <a href="details">
                                <img src="assets/images/thumb1.gif" alt="" title="" class="thumb" border="0" />
                            </a>
                        </div>
                    </div>

                    <div class="new_prod_box">
                        <a href="details.html">product name</a>
                        <div class="new_prod_bg">
                            <span class="new_icon">
                                <img src="assets/images/promo_icon.gif"
                                     alt="" title="" />
                            </span> <a href="details.html">
                                <img src="assets/images/thumb2.gif" alt="" title="" class="thumb" border="0" />
                            </a>
                        </div>
                    </div>

                    <div class="new_prod_box">
                        <a href="details.html">product name</a>
                        <div class="new_prod_bg">
                            <span class="new_icon">
                                <img src="assets/images/promo_icon.gif"
                                     alt="" title="" />
                            </span> <a href="details.html">
                                <img src="assets/images/thumb3.gif" alt="" title="" class="thumb" border="0" />
                            </a>
                        </div>
                    </div>

                </div>

                <div class="right_box">

                    <div class="title">
                        <span class="title_icon">
                            <img src="assets/images/bullet5.gif"
                                 alt="" title="" />
                        </span>Categories
                    </div>

                    <ul class="list">
                        <li><a href="#">accesories</a></li>
                        <li><a href="#">flower gifts</a></li>
                        <li><a href="#">specials</a></li>
                        <li><a href="#">hollidays gifts</a></li>
                        <li><a href="#">accesories</a></li>
                        <li><a href="#">flower gifts</a></li>
                        <li><a href="#">specials</a></li>
                        <li><a href="#">hollidays gifts</a></li>
                        <li><a href="#">accesories</a></li>
                        <li><a href="#">flower gifts</a></li>
                        <li><a href="#">specials</a></li>
                    </ul>

                    <div class="title">
                        <span class="title_icon">
                            <img src="assets/images/bullet6.gif"
                                 alt="" title="" />
                        </span>Partners
                    </div>

                    <ul class="list">
                        <li><a href="#">accesories</a></li>
                        <li><a href="#">flower gifts</a></li>
                        <li><a href="#">specials</a></li>
                        <li><a href="#">hollidays gifts</a></li>
                        <li><a href="#">accesories</a></li>
                        <li><a href="#">flower gifts</a></li>
                        <li><a href="#">specials</a></li>
                        <li><a href="#">hollidays gifts</a></li>
                        <li><a href="#">accesories</a></li>
                    </ul>

                </div>


            </div>
            <!--end of right content-->




            <div class="clear"></div>
        </div>
        <!--end of center content-->


        <div class="footer">
            <div class="left_footer">
                <img src="assets/images/footer_logo.gif" alt="" title="" /><br /> <a href="http://csscreme.com/freecsstemplates/" title="free templates">
                    <img src="assets/images/csscreme.gif" alt="free templates"
                         title="free templates" border="0" />
                </a>
            </div>
            <div class="right_footer">
                <a href="#">home</a> <a href="#">about us</a> <a href="#">services</a>
                <a href="#">privacy policy</a> <a href="#">contact us</a>

            </div>


        </div>


    </div>

</body>
</html>
    