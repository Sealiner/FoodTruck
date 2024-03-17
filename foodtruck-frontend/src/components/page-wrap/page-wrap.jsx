import React from "react";
import classNames from "classnames";
import PropTypes from "prop-types";

require("./page-wrap.less")

const PageWrap = ({
                      children,
                      className
                  }) => (
    <div className={classNames('page-wrap', className)}>
        {children}
    </div>
);

PageWrap.propTypes = {
    children: PropTypes.node,
    className: PropTypes.string
};

export default PageWrap;
