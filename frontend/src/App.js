import { useState} from 'react'

import {
    Layout,
    Menu,
    Button,

} from 'antd';

import {


    PlusOutlined
} from '@ant-design/icons';
import './App.css';
import GuestDrawerForm from "./GuestDrawerForm";
import TableDrawerForm from "./TableDrawerForm";



const {Header, Content, Footer} = Layout;
const {SubMenu} = Menu;






function App() {




    const [showDrawer, setShowDrawer] = useState(false);

    const [showGuestDrawer, setShowGuestDrawer] = useState(false);










    return <Layout style={{minHeight: '100vh'}}>

        <Layout className="site-layout">
            <Header className="site-layout-background" style={{padding: 0}}/>
            <Content style={{margin: '0 16px'}}>

                <div className="site-layout-background" style={{padding: 24, minHeight: 360}}>
                    <Button
                        onClick={() => setShowDrawer(!showDrawer)}
                        type="primary" shape="round" icon={<PlusOutlined/>} size="small">
                        Add New Table
                    </Button>


                    <TableDrawerForm
                        showDrawer={showDrawer}
                        setShowDrawer={setShowDrawer}
                    />

                <empty/>

                    <Button
                        onClick={() => setShowGuestDrawer(!showGuestDrawer)}
                        type="primary" shape="round" icon={<PlusOutlined/>} size="small">
                        Add New Guest
                    </Button>


                    <GuestDrawerForm
                        showGuestDrawer={showGuestDrawer}
                        setShowGuestDrawer={setShowGuestDrawer}
                    />

                </div>
            </Content>
            <Footer style={{textAlign: 'center'}}>

            </Footer>
        </Layout>
    </Layout>
}

export default App;

