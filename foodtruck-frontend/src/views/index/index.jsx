import React from "react";
import {createRoot} from "react-dom/client";
import PageWrap from "../../components/page-wrap/page-wrap.jsx";
import PageLoading from "../../components/page-loading/page-loading.jsx";
import {allData, searchFood} from "../../api/app";
import {
    IconButton,
    InputBase,
    Paper,
    Table,
    TableBody,
    TableCell,
    TableContainer,
    TableHead,
    TableRow
} from "@mui/material";
import SearchIcon from '@mui/icons-material/Search';

require("./index.less")

class Index extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            pageLoading: true,
            searching: false,
            searchValue: "",
            rows:[]
        }
    };

    searchData(){
        const self = this;
        self.setState({
            searching: true
        });
        searchFood({foodItem: self.state.searchValue}).then(res=> {
            if (res.code === 200) {
                self.setState({
                    rows: res.result
                })
            }
        }).catch(err => {
                console.log(err);
        }).finally(()=>{
            self.setState({
                searching: false
            })
        })
    }

    // handle enter key
    handleKeyPress(e){
        if(e.keyCode == 13) {
            this.searchData();
        }
    }


    componentDidMount() {
        const self = this;
        allData({}).then(res=>{
            if (res.code === 200) {
                self.setState({
                    pageLoading:false,
                    rows: res.result
                })
            } else {
                console.log(res.message);
            }
        }).catch(err => {
            console.log(err);
        })
    }

    render() {
        return(
            <React.Fragment>
                {
                    this.state.pageLoading ? (
                        <PageLoading show={true}></PageLoading>
                    ) : (
                        <React.Fragment>
                            <div className="table-wrap">
                                <div className="search-bar">
                                    <Paper
                                        sx={{ p: '2px 4px', display: 'flex', alignItems: 'center', width: 400 }}
                                    >
                                        <InputBase
                                            sx={{ ml: 1, flex: 1 }}
                                            placeholder="Food Item"
                                            onKeyDown={e=>this.handleKeyPress(e)}
                                            onChange={(e) => {this.setState({searchValue: e.target.value})} }
                                        />
                                        <IconButton type="button" sx={{ p: '10px' }} aria-label="search"
                                                    onClick={() => {
                                            this.searchData();
                                        }}>
                                            <SearchIcon />
                                        </IconButton>
                                    </Paper>
                                </div>
                                <TableContainer component={Paper}>
                                    <Table>
                                        <TableHead>
                                            <TableRow>
                                                <TableCell>FoodItems</TableCell>
                                                <TableCell>FacilityType</TableCell>
                                                <TableCell>LocationDescription</TableCell>
                                                <TableCell>Address</TableCell>
                                                <TableCell>Applicant</TableCell>
                                            </TableRow>
                                        </TableHead>
                                        <TableBody>
                                            {this.state.rows.map((row) => (
                                                <TableRow key={row.locationId}>
                                                    <TableCell component="th" scope="row">
                                                        {row.foodItems}
                                                    </TableCell>
                                                    <TableCell align="right">{row.facilityType}</TableCell>
                                                    <TableCell align="right">{row.locationDescription}</TableCell>
                                                    <TableCell align="right">{row.address}</TableCell>
                                                    <TableCell align="right">{row.applicant}</TableCell>
                                                </TableRow>
                                            ))}
                                        </TableBody>
                                    </Table>
                                </TableContainer>
                            </div>
                        </React.Fragment>
                    )
                }
            </React.Fragment>
        )
    }
}

const root = createRoot(document.getElementById("root"));
root.render(<PageWrap><Index /></PageWrap>);