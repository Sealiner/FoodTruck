import React from 'react';
import PropTypes from "prop-types";

require('./page-loading.less');

const PageLoading = ({
    show
}) => {
    return (
        <React.Fragment>
            {
                show ? (
                    <div className="page-loading">
                        <span style={{ fontSize: 40 }}>
                            Loading……
                        </span>
                    </div>):(<div></div>)
            }
        </React.Fragment>

    )
};

PageLoading.propTypes = {
    show: PropTypes.bool.isRequired
};

export default PageLoading;


